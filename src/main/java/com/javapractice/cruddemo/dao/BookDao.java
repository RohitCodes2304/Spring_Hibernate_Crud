package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Book;

import java.util.List;

public interface BookDao {

    public void save(Book book);
    public Book findbyID(Integer id);
    public List<Book> findAll();
    public List<Book> findByName(String bookname);

    public void updateBookName(Book book);

    public void delete(int id);

}
