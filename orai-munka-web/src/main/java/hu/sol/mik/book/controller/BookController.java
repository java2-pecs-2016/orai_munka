package hu.sol.mik.book.controller;

import hu.sol.mik.book.bean.Book;
import hu.sol.mik.book.dao.BookDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

	private BookDao bookDao;

	public BookController(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@RequestMapping("/bookList")
	public String listBooks(Model model) {
		model.addAttribute("bookList", bookDao.listAll());
		return "book_list";
	}

	@RequestMapping("/bookDetails")
	public String detailBook(Long bookId, Model model) {
		Book book = bookDao.findBookbyid(bookId);
		model.addAttribute("book", book);
		return "book_details";
	}

	@RequestMapping(path = "/bookEdit", method = RequestMethod.GET)
	public String editBookPost(@RequestParam(required = false) Long bookId, Model model) {
		Book book;
		if (bookId == null) {
			book = new Book();
		} else {
			book = bookDao.findBookbyid(bookId);
		}

		model.addAttribute("book", book);
		return "book_edit";
	}

	@RequestMapping(path = "/bookEdit", method = RequestMethod.POST)
	public String editBookGet(@ModelAttribute Book book) {
		if (book.getId() == null) {
			bookDao.saveBook(book);
		} else {
			bookDao.updateBook(book);
		}
		return "redirect:bookList";
	}

}
