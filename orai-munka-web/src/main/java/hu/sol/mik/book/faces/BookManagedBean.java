package hu.sol.mik.book.faces;

import java.util.List;

import hu.sol.mik.book.bean.Book;
import hu.sol.mik.book.dao.BookDao;
import hu.sol.mik.book.dao.impl.BookDaoImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BookManagedBean {

	private BookDao bookDao;
	private List<Book> bookList;
	private Book editedBook;
	private List<Book> selectedBooks;

	public BookManagedBean() {
		bookDao = new BookDaoImpl();
		listBooks();
	}

	private void listBooks() {
		bookList = bookDao.listAll();
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public Book getEditedBook() {
		return editedBook;
	}

	public void setEditedBook(Book editedBook) {
		System.out.println(editedBook);
		this.editedBook = editedBook;
	}

	public void saveBook() {
		if (editedBook.getId() != null) {
			bookDao.updateBook(editedBook);
		} else {
			bookDao.saveBook(editedBook);
			listBooks();
		}
		editedBook = null;
	}

	public void newBook() {
		editedBook = new Book();
	}

	public List<Book> getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(List<Book> selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public void deleteSelectedBooks() {
		for (Book b : selectedBooks) {
			bookDao.delete(b);
		}
		listBooks();
	}

}
