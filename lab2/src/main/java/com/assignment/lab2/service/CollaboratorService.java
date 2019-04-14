package com.assignment.lab2.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lab2.dao.EmployeeDao;
import com.assignment.lab2.entity.Employee;

@Service
public class CollaboratorService {
	@Autowired
	EmployeeDao employeeDao;
	
	
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

}
