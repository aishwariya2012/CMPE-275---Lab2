package com.assignment.lab2.service;

//import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lab2.dao.EmployeeDao;
import com.assignment.lab2.dao.EmployerDao;
import com.assignment.lab2.entity.*;

@Service
@Transactional
public class EmployerService {
	
	@Autowired
	EmployerDao empDao;
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public Optional<EmployerEntity> GetEmployer(long empid){
		return this.empDao.findById(empid);
	}
	
	@Transactional
	public Optional<EmployerEntity> GetEmployerByName(String name){
		return this.empDao.findByName(name);
	}
	
	@Transactional
	public EmployerEntity UpdateEmployer(EmployerEntity employer) {
	
		
		this.empDao.save(employer);
		return employer;
	}
	
	@Transactional
	public Optional<EmployerEntity> DeleteEmployer(long empid) {
		Optional<EmployerEntity> emp = this.empDao.findById(empid);
		if(emp.isPresent()) {
			this.empDao.deleteById(empid);
		}
		return emp;
	}
	
	@Transactional
	public boolean EmployerExists(long id) {
		boolean opt = this.employeeDao.findEmpId(id);
		return opt;
	}
	
	@Transactional
	public EmployerEntity AddEmployer(EmployerEntity employer){
		return this.empDao.save(employer);
		
	}

}
