package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    EntityManager entityManager;
    BookDaoImpl(){

    }
    @Autowired
    public BookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findbyID(Integer id) {
       return entityManager.find(Book.class,id);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> typedQuery= entityManager.createQuery("from Book order by bnumber",Book.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Book> findByName(String bookname) {

        TypedQuery<Book> typedQuery=entityManager.createQuery("From Book where bname=:bkname",Book.class);
        typedQuery.setParameter("bkname",bookname);
        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public void updateBookName(Book book) {

        entityManager.merge(book);

    }

    @Transactional
    @Override
    public void delete(int id) {
        Book bk=entityManager.find(Book.class,id);
        entityManager.remove(bk);
    }
}
