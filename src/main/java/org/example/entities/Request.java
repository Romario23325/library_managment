package org.example.entities;



import jakarta.persistence.*;


import java.awt.print.Book;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String note;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "returned_at")
    private Date returnedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "request_book",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    public void setBooks(Set<Book> books) {
    }

    public void setUser(User client) {

    }

    public enum Status {
        CREATED, COMPLETED
    }

    // Getters and Setters
}

