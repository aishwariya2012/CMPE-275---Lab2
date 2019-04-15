package com.assignment.lab2.service;

import java.util.NoSuchElementException;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lab2.dao.EmployeeDao;
import com.assignment.lab2.entity.Employee;

@Service
public class CollaboratorService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public boolean EmployeeCheck(Long empid1,Long empid2) {
		try {
			Employee employee1 = this.employeeDao.findById(empid1).get();
			Employee employee2 = this.employeeDao.findById(empid2).get();
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@Transactional
	public boolean CollaborationCheck(Long empid1,Long empid2) {
		
			Employee employee1 = this.employeeDao.findById(empid1).get();
			Employee employee2 = this.employeeDao.findById(empid2).get();
			
			if(employee1.getCollaborators().contains(employee2) && employee2.getCollaborators().contains(employee1)) {
				return true;
			}
			else {
				return false;
			}
			
	}
	
	@Transactional
	public boolean CollaboratorsAddition(Long id1,Long id2){
		Employee emp1 = this.employeeDao.findById(id1).get();
		Employee emp2 = this.employeeDao.findById(id2).get();
		
		emp1.getCollaborators().add(emp2);
			this.employeeDao.save(emp1);
		
		
		emp2.getCollaborators().add(emp1);
			this.employeeDao.save(emp2);
		
		
		return true;
	}
	
	@Transactional
	public boolean CollaboratorsDeletion(Long id1,Long id2) {
		Employee emp1 = this.employeeDao.findById(id1).get();
		Employee emp2 = this.employeeDao.findById(id2).get();
		
		emp1.getCollaborators().remove(emp2);
		this.employeeDao.save(emp1);
		
		emp2.getCollaborators().remove(emp1);
		this.employeeDao.save(emp2);
		
		return true;
	}

}
