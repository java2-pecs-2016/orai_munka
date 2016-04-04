package hu.sol.mik.book.dao;

import java.util.List;

import hu.sol.mik.book.bean.Book;

public interface BookDao {

	/**
	 * add vissza a könyvet ID alapján
	 * @param id
	 * @return Book
	 */
	Book findBookbyid(Long id);

	/**
	 * add vissza könyveket author alapján
	 * @param author
	 * @return Könyv lista!
	 */
	List<Book> listBookByAuthor(String author);

	List<Book> listAll();

	void saveBook(Book book);

	void updateBook(Book book);

}
