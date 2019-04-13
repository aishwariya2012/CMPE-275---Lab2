package com.assignment.lab2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.lab2.entity.*;

@Repository
public interface EmployerDao extends JpaRepository<EmployerEntity,Integer> {

}
