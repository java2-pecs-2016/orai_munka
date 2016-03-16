package hu.sol.mik.book.servlet;

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

public class BookListServlet extends HttpServlet {

	private BookDao bookDao;

	@PostConstruct
	private void initialize() {
		bookDao = new BookDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("bookList", new BookService().getBookList());
		navigateToBookList(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("bookList", bookDao.listAll());
		navigateToBookList(req, resp);
	}

	private void navigateToBookList(HttpServletRequest req,
			HttpServletResponse resp) {
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/book/book_list.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
