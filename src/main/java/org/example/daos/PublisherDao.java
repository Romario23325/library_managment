package org.example.daos;


import org.example.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PublisherDao {
    private final Session session;
    private Transaction transaction;

    public PublisherDao(Session session) {
        this.session = session;
    }

    public Publisher create(Publisher publisher) {
        transaction = session.beginTransaction();
        try {
            session.persist(publisher);
            transaction.commit();
            return publisher;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}

