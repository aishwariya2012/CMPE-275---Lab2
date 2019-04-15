package com.assignment.lab2.service;

//import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lab2.dao.EmployerDao;
import com.assignment.lab2.entity.*;

@Service
@Transactional
public class EmployerService {
	
	@Autowired
	EmployerDao empDao;
	
	@Transactional
	public EmployerEntity GetEmployer(Long empid){
		EmployerEntity res=empDao.findById(empid).get();
		return res;
	}
	
	@Transactional
	public void DeleteEmployer(Long empid) {
		 this.empDao.deleteById(empid);
	}
	
	@Transactional
	public EmployerEntity AddEmployer(EmployerEntity employer){
		return this.empDao.save(employer);
		
	}

}
