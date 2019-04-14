package com.assignment.lab2.service;



//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.lab2.dao.EmployeeDao;
import com.assignment.lab2.entity.Employee;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeDao empDao;
	
	
	public Employee GetEmployee(Long empid){
		Employee rres=this.empDao.findById(empid).get();
		return rres;
	}
	
	public void DeleteEmployee(Long empid) {
		 this.empDao.deleteById(empid);
	}
	
	public Employee AddEmployee(Employee employee){
		return this.empDao.save(employee);
		
	}
	
	public Employee UpdateEmployee(Employee employee) {
		return this.empDao.save(employee);
	}


}
