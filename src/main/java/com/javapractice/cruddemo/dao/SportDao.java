package com.javapractice.cruddemo.dao;

import com.javapractice.cruddemo.entity.Sport;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface SportDao {
    public void save(Sport sport);

    public List<Sport> findAllSports();

    public List<Sport> findSportbyName(String sportName);

    public void deleteSport(int id);
}
