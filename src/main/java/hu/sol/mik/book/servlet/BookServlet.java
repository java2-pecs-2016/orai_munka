package hu.sol.mik.book.servlet;

import hu.sol.mik.book.bean.Book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		book.setTitle("Utikalaúz Java programozóknak");
		book.setDescription("Java könyv");
		book.setAuthor("Dr. Gaizler Judit");
		book.setPubYear(2000);
		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/book/book_details.jsp");
		requestDispatcher.forward(req, resp);
	}

}
