package hu.sol.mik.book.servlet;

import hu.sol.mik.book.bean.Book;
import hu.sol.mik.book.dao.BookDao;
import hu.sol.mik.book.dao.impl.BookDaoImpl;
import hu.sol.mik.book.service.BookService;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookDetailsServlet extends HttpServlet {

	private BookDao bookDao;

	@PostConstruct
	private void initialize() {
		bookDao = new BookDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("bookId");
		if (parameter == null) {
			throw new RuntimeException("Missing bookId");
		}
		Long bookId = Long.valueOf(parameter);
		Book book = bookDao.findBookbyid(bookId);
		navigateToBookDetails(req, resp, book);
	}

	private void navigateToBookDetails(HttpServletRequest req, HttpServletResponse resp, Book book)
			throws ServletException, IOException {
		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/book/book_details.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
