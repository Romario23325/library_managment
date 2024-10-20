package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.awt.print.Book;
import java.util.Set;

    @Entity
    @Table(name = "publisher")
    public class Publisher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String address;

        @OneToMany(mappedBy = "publisher")
        private Set<Book> books;

        public void setName(String penguinBooks) {
        }

        public void setAddress(String s) {
        }

        // Getters and Setters



}
