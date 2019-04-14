package com.assignment.lab2.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lab2.entity.AddressEntity;
import com.assignment.lab2.entity.EmployerEntity;
import com.assignment.lab2.service.EmployeeService;
import com.assignment.lab2.service.EmployerService;

@RestController
@RequestMapping("/")
//@ResponseStatus(HttpStatus.NOT_FOUND)
@CrossOrigin(origins = "*")
public class EmployeerController {
	
	
	@Autowired
	EmployerService EmployerService;
	
	//@Autowired
	//EmployeeService EmployeeService;

//	@GetMapping("/hello")
//	public String hello() {
//		Employee emp = new Employee();  
//		emp.setName("ABC");
//		return "HelloAish";
//	}
	 @RequestMapping(value = "employer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> addNewUser(
    		 @RequestParam(value="name",required = true) String name, 
    		 @RequestParam(value="description", required=false) String description, 
    		 @RequestParam(value="street",required=false) String street,
    		 @RequestParam(value="city",required=false) String city, 
    		 @RequestParam(value="state",required=false) String state,
    		 @RequestParam(value="zip", required=false) String zip) 
	 {
		 
		 
		 if(name==null) {
			 System.out.print("OK");
			 
			// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 
		 AddressEntity address = new AddressEntity(city, street, state, zip);
		 //this.Addservice.AddAddress(address);
		 //if(!service.isPresent(Emp))
		 //return new ResponseEntity<EmployerEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		 
		 EmployerEntity employer = new EmployerEntity(name, description, address);
		 
//		 Employee employee = new Employee(name, email, title, (employer.isPresent())?employer.get():null, address);
		 
         return new ResponseEntity<EmployerEntity>(this.EmployerService.AddEmployer(employer),HttpStatus.OK);
}
}
