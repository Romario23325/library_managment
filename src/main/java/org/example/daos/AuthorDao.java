package org.example.daos;

import org.example.entities.Author;
import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao {
    private final Session session;
    private Transaction transaction;

    public AuthorDao(Session session) {
        this.session = session;
    }
    

    public Author create(Author author) {
         transaction = session.beginTransaction();
         try {
             session.persist(author);
             transaction.commit();
             return author;
         } catch (Exception e) {
             transaction.rollback();
             throw new RuntimeException(e);
         }






    }
}
