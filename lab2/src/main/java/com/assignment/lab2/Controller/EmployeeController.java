package com.assignment.lab2.Controller;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lab2.entity.AddressEntity;
import com.assignment.lab2.entity.*;
import com.assignment.lab2.service.EmployeeService;
import com.assignment.lab2.service.EmployerService;
import com.assignment.lab2.dao.*;

@RestController
@RequestMapping("/")
//@ResponseStatus(HttpStatus.NOT_FOUND)
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService EmployeeService;
	
	@Autowired
	EmployerService EmployerService;
	
	@Autowired
	EmployerDao empDao;
	
	
	@RequestMapping(value="employee", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<?> addEmployee(
			 @RequestParam(value="name",required = true) String name,
			 @RequestParam(value="email",required = true) String email,
			 @RequestParam(value="title",required = false) String title,
			 @RequestParam(value="street",required=false) String street,
    		 @RequestParam(value="city",required=false) String city, 
    		 @RequestParam(value="state",required=false) String state,
    		 @RequestParam(value="zip", required=false) String zip,
    		 @RequestParam(required = true) Long EmployerID,
    		 @RequestParam(required = false) Long ManagerID
			)
	{
		
		        try{
		        	AddressEntity address = new AddressEntity(city,street,state,zip);
		        Employee ManagerDetails = null;
		        EmployerEntity employer = this.EmployerService.GetEmployer(EmployerID);
		        System.out.print(employer);
		       
		        if(ManagerID!=null) {
		        	 ManagerDetails = this.EmployeeService.GetEmployee(ManagerID).get();
		        	Long id = ManagerDetails.getEmployer().getId();
		        	if(id != EmployerID ) {
		        		return new ResponseEntity<>("Manager Id Not Valid",HttpStatus.BAD_REQUEST);
		        	}
		        	
		        }
		        
				Employee employee = new Employee(name,email,title,address,employer,ManagerDetails);
				System.out.print(employee);
				return new ResponseEntity<Employee>(this.EmployeeService.AddEmployee(employee),HttpStatus.OK);
			}
		        catch(NoSuchElementException e){
		        	 return new ResponseEntity<>("Not A Valid Employeer,It is not created earlier",HttpStatus.BAD_REQUEST);
		        
		        }
		        catch(DataIntegrityViolationException e ) {
		        	return new ResponseEntity<>("Email ALready Exist",HttpStatus.BAD_REQUEST);
		        	
		        }
	}
	
	@RequestMapping(value="employee/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> GetEmployeeDetails(
			@PathVariable(required = true) Long id)
	{
		try {
			Optional<Employee> temp =this.EmployeeService.GetEmployee(id) ;
			return new ResponseEntity<Employee>(temp.get(),HttpStatus.OK);
					
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>("Employee Not Found,Enter A Valid Value",HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="employee", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> UpdateEmployeeDetails(
			 @PathVariable(required = true) Long id,
			 @RequestParam(value="name",required = true) String name,
			 @RequestParam(value="email",required = true) String email,
			 @RequestParam(value="title",required = false) String title,
			 @RequestParam(value="street",required=false) String street,
    		 @RequestParam(value="city",required=false) String city, 
    		 @RequestParam(value="state",required=false) String state,
    		 @RequestParam(value="zip", required=false) String zip,
    		 @RequestParam(required = true) Long EmployerID,
    		 @RequestParam(required = false) Long ManagerID
			 
			 )
	{
		
		   Optional <Employee> temp = this.EmployeeService.GetEmployee(id);
		    if(!temp.isPresent()) {
		    	return new ResponseEntity<>("Employee Not Found,Enter A Valid Value",HttpStatus.NOT_FOUND);
		    }
		    
		    Employee temp1 = temp.get();
		    if(name!=null)
		    
		    return new ResponseEntity<>("Employee Not Found,Enter A Valid Value",HttpStatus.NOT_FOUND);

			
		
	}
}
	
        


