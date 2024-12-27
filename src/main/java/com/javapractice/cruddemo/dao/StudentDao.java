package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student tstudent);

    public List<Student> findAll();

    public List<Student> findStudentByName(String firstname);

    public int removeAllStudents();
}
