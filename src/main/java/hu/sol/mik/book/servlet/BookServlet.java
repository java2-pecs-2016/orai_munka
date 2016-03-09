package hu.sol.mik.book.servlet;

import hu.sol.mik.book.bean.Book;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		book.setTitle("Utikalaúz Java programozóknak");
		book.setDescription("Java könyv");
		book.setAuthor("Dr. Gaizler Judit");
		book.setPubYear(2000);
		navigateToBookDetails(req, resp, book);
	}

	private void navigateToBookDetails(HttpServletRequest req,
			HttpServletResponse resp, Book book) throws ServletException,
			IOException {
		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/book/book_details.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		try {
			BeanUtils.populate(book, req.getParameterMap());
			navigateToBookDetails(req, resp, book);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
