package com.assignment.lab2.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.assignment.lab2.entity.*;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {
	
	@Query(value="Select CASE WHEN count(e)>0 THEN true ELSE false END FROM Employee e where e.employer.id = ?1")
	boolean findEmpId(long id);
}
