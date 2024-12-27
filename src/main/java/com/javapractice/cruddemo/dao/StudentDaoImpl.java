package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student tstudent) {
        entityManager.persist(tstudent);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> st=entityManager.createQuery("From Student",Student.class);
        return st.getResultList();
    }

    @Override
    public List<Student> findStudentByName(String firstname) {

        TypedQuery<Student> typedQuery=entityManager.createQuery("From Student where firstname=:fname",Student.class);
        typedQuery.setParameter("fname",firstname);
        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public int removeAllStudents() {

        int numupdatedRows= entityManager.createQuery("Delete from Student").executeUpdate();
        return numupdatedRows;
    }
}
