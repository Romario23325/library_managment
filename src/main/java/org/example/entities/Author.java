package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.awt.print.Book;
import java.util.Set;

    @Entity
    @Table(name = "author")
    public class Author {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String firstname;
        private String lastname;
        private String bio;

        @ManyToMany(mappedBy = "authors")
        private Set<Book> books;

        public void setFirstname(String s) {
        }

        public void setLastname(String fitzgerald) {
        }

        public void setBio(String americanNovelist) {

        }

        // Getters and Setters
    }


