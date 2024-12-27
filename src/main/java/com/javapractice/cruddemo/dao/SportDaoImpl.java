package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Sport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportDaoImpl implements SportDao{

    EntityManager entityManager;
    SportDaoImpl(){}

    @Autowired
    public SportDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Sport sport) {
        entityManager.persist(sport);
    }

    @Override
    public List<Sport> findAllSports() {

        TypedQuery<Sport> typedQuery=entityManager.createQuery("From Sport",Sport.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Sport> findSportbyName(String sportName) {
        TypedQuery<Sport> typedQuery1=entityManager.createQuery("From Sport where firstname=:fname",Sport.class);
        typedQuery1.setParameter("fname",sportName);
        return typedQuery1.getResultList();

    }
    @Transactional
    @Override
    public void deleteSport(int id) {
        Sport sport=entityManager.find(Sport.class,id);

        entityManager.remove(sport);
    }
}
