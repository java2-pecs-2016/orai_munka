package hu.sol.mik.book.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import hu.sol.mik.book.bean.Book;
import hu.sol.mik.book.dao.BookDao;
import hu.sol.mik.book.util.HibernateUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public Book findBookbyid(Long id) {
		// Session kinyitása
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Tranzakció indítása
		Transaction transaction = session.beginTransaction();

		Book book = session.get(Book.class, id);

		// commit
		transaction.commit();
		// session zárása
		session.close();
		
		//return
		return book;
	}

	@Override
	public List<Book> listBookByAuthor(String author) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Criteria crit = session.createCriteria(Book.class);
		Criterion authorCrit = Restrictions.like("author", author);
		crit.add(authorCrit);
		List<Book> books = crit.list();
		transaction.commit();
		session.close();
		return books;
	}

	@Override
	public List<Book> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Criteria crit = session.createCriteria(Book.class);
		List<Book> books = crit.list();
		transaction.commit();
		session.close();
		return books;
	}

	@Override
	public void saveBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}

	@Override
	public void updateBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
		session.close();
	}

}
