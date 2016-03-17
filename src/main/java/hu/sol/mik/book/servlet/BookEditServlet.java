package hu.sol.mik.book.servlet;

import hu.sol.mik.book.bean.Book;
import hu.sol.mik.book.dao.BookDao;
import hu.sol.mik.book.dao.impl.BookDaoImpl;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class BookEditServlet extends HttpServlet {

	private BookDao bookDao;

	@PostConstruct
	private void initialize() {
		bookDao = new BookDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("bookId");
		if (parameter == null) {
			navigateToBookEdit(req, resp, new Book());
		} else {
			Long bookId = Long.valueOf(parameter);
			Book book = bookDao.findBookbyid(bookId);
			navigateToBookEdit(req, resp, book);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book();
		try {
			BeanUtils.populate(book, req.getParameterMap());
			if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
				bookDao.saveBook(book);
			} else {
				bookDao.updateBook(book);
			}
			navigateToBookList(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void navigateToBookList(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect("bookList");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void navigateToBookEdit(HttpServletRequest req, HttpServletResponse resp, Book book) {
		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/book/book_edit.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
