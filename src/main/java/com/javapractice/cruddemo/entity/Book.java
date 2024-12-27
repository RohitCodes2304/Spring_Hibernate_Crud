package com.javapractice.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "bnumber=" + bnumber +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_number")
    private int bnumber;

    @Column(name = "book_name")
    private String bname;


    @Column(name = "book_author")
    private String bauthor;


    public Book() {
    }

    public Book(String bname, String bauthor) {
        this.bname = bname;
        this.bauthor = bauthor;
    }

    public int getBnumber() {
        return bnumber;
    }

    public void setBnumber(int bnumber) {
        this.bnumber = bnumber;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
}
