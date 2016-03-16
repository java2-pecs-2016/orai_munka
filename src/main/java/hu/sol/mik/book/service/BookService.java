package hu.sol.mik.book.service;

import hu.sol.mik.book.bean.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class BookService {

	private File file = new File("books.ser");

	@SuppressWarnings({ "resource", "unchecked" })
	public List<Book> getBookList() {
		List<Book> bookList = new ArrayList<Book>(getBookMap().values());
		Collections.sort(bookList, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return (int) (o1.getId() - o2.getId());
			}
		});
		return bookList;
	}

	public synchronized void updateBook(Book book) {
		if (book == null || book.getId() == null) {
			throw new RuntimeException("Missing book or ID" + book);
		}
		Map<Long, Book> bookMap = getBookMap();
		if (bookMap.get(book.getId()) == null) {
			throw new RuntimeException("Book is missing" + book);
		}
		bookMap.remove(book.getId());
		bookMap.put(book.getId(), book);
		writeBookMap(bookMap);
	}

	public synchronized void addBook(Book book) {
		if (book == null) {
			throw new RuntimeException("Missing book" + book);
		}
		Map<Long, Book> bookMap = getBookMap();
		book.setId(getNextId());
		System.out.println("nextId : " + book.getId());
		bookMap.put(book.getId(), book);
		writeBookMap(bookMap);
	}

	private long getNextId() {
		Map<Long, Book> bookMap = getBookMap();
		Set<Long> keySet = bookMap.keySet();
		List<Long> ids = new ArrayList<Long>(keySet);
		Collections.sort(ids, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return (int) (o1 - o2);
			}
		});
		if (ids.size() == 0) {
			return 0;
		}
		return ids.get(ids.size() - 1) + 1;
	}

	public synchronized void deleteBook(Long id) {
		if (id == null) {
			throw new RuntimeException("Missing book or ID" + id);
		}
		Map<Long, Book> bookMap = getBookMap();
		bookMap.remove(id);
		writeBookMap(bookMap);
	}

	public Book getBookById(Long id) {
		return getBookMap().get(id);
	}

	private Map<Long, Book> getBookMap() {
		Object o = null;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			return new HashMap<Long, Book>();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return (Map<Long, Book>) o;
	}

	private void writeBookMap(Map<Long, Book> bookMap) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bookMap);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
