package org.example.daos;


import org.example.entities.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RequestDao {
    private final Session session;
    private Transaction transaction;

    public RequestDao(Session session) {
        this.session = session;
    }


    public Request create(Request request) {
        transaction = session.beginTransaction();
        try {
            session.persist(request);
            transaction.commit();
            return request;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}