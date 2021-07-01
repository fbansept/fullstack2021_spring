package com.example.demo.dao;

import com.example.demo.model.Chef;
import com.example.demo.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDao extends JpaRepository<Chef,Integer> {

}