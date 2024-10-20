package org.example.daos;


import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class BookDao {
    private final Session session;
    private Transaction transaction;

    public BookDao(Session session) {
        this.session = session;
    }

    public Book create(Book book, Set<Author> authors, Publisher publisher) {
        transaction = session.beginTransaction();
        try {
            book.setAuthors(authors);
            book.setPublisher(publisher);
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }

    }

    public List<Book> searchBooksByAuthor(String authorName) {
        String hql = "SELECT b FROM Book b JOIN b.authors a where concat(a.firstName, ' ', a.lastName) like :name";
        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("name", "%".concat(authorName).concat("%"));
        return query.getResultList();
    }
}