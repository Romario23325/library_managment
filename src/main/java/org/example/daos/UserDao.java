package org.example.daos;


import org.example.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
    private final Session session;
    private Transaction transaction;

    public UserDao(Session session) {
        this.session = session;
    }
    public User findByUsername(String username) {
        String query = "select d from User d where d.username = :username";
        Query<User> findByUsernameQuery = session.createQuery(query, User.class);
        findByUsernameQuery.setParameter("username", username);
        return findByUsernameQuery.getSingleResultOrNull();
    }


    public User create(User user) {
        transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}