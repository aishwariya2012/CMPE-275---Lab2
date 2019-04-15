package com.assignment.lab2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.assignment.lab2.entity.*;

@Repository
public interface EmployerDao extends JpaRepository<EmployerEntity,Long> {
	@Query(value="Select e from EmployerEntity e where e.name = ?1")
	Optional<EmployerEntity> findByName(String name);
}
