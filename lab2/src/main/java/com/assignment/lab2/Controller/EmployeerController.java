package com.assignment.lab2.Controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.lab2.entity.AddressEntity;
import com.assignment.lab2.entity.EmployerEntity;
//import com.assignment.lab2.service.EmployeeService;
import com.assignment.lab2.service.EmployerService;

@RestController
@RequestMapping("/")
//@ResponseStatus(HttpStatus.NOT_FOUND)
@CrossOrigin(origins = "*")
public class EmployeerController {
	
	
	@Autowired
	EmployerService EmployerService;
	
//	@Autowired
//	EmployeeService EmployeeService;

//	@GetMapping("/hello")
//	public String hello() {
//		Employee emp = new Employee();  
//		emp.setName("ABC");
//		return "HelloAish";
//	}
	 @RequestMapping(value = "employer", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
     public ResponseEntity<?> addNewUser(
    		 @RequestParam(value="name",required = true) String name, 
    		 @RequestParam(value="description", required=false) String description, 
    		 @RequestParam(value="street",required=false) String street,
    		 @RequestParam(value="city",required=false) String city, 
    		 @RequestParam(value="state",required=false) String state,
    		 @RequestParam(value="zip", required=false) String zip) {
		 
		 
		 if(name==null) {
			 System.out.print("Name is empty");
			 
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		 
		 AddressEntity address = new AddressEntity(city, street, state, zip);
		 //this.Addservice.AddAddress(address);
		 //if(!service.isPresent(Emp))
		 //return new ResponseEntity<EmployerEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		 
		 EmployerEntity employer = new EmployerEntity(name, description, address);
		 
//		 Employee employee = new Employee(name, email, title, (employer.isPresent())?employer.get():null, address);
		 
         return new ResponseEntity<EmployerEntity>(this.EmployerService.AddEmployer(employer),HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "employer/{id}", method = RequestMethod.GET)
	 public ResponseEntity<?> getUser(
			 @PathVariable(required = true) Long id) {
//			 @RequestParam(value="id", required=true) long id) {
		 
		 Optional<EmployerEntity> optionalemployer = this.EmployerService.GetEmployer(id);
		 if(!optionalemployer.isPresent()) {
			 return new ResponseEntity<>("Employer Not Found Enter Valid Value",HttpStatus.NOT_FOUND);
		 } else {
			 EmployerEntity employer = optionalemployer.get();
			 return new ResponseEntity<EmployerEntity>(employer, HttpStatus.OK);
		 }
		 
	 }
	 
	 @RequestMapping(value = "employer/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<?> updateUser(
			 @PathVariable(required = true) Long id,
//			 @RequestParam(value="id", required=true) long id,
			 @RequestParam(value="name",required = true) String name, 
    		 @RequestParam(value="description", required=false) String description, 
    		 @RequestParam(value="street",required=false) String street,
    		 @RequestParam(value="city",required=false) String city, 
    		 @RequestParam(value="state",required=false) String state,
    		 @RequestParam(value="zip", required=false) String zip) {
		 Optional<EmployerEntity> optionalemployer = this.EmployerService.GetEmployer(id);
//		 Optional<EmployerEntity> optionalemployer = this.EmployerService.GetEmployerByName(name);
		 if(!optionalemployer.isPresent()) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 } else {
			 EmployerEntity employer = optionalemployer.get();
			 if(name==null) {
				 	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			 } else {
			 		if(name!=null) {
						employer.setName(name);
					}
					if(description!=null) {
						employer.setDescription(description);
					}
					AddressEntity address = employer.getAddress();
					String prevstreet = address.getStreet();
					String prevcity = address.getCity();
					String prevstate = address.getState();
					String prevzip = address.getZip();
					if(street!=null) {
						prevstreet = street;
					}
					if(city!=null) {
						prevcity = city;
					}
					if(state!=null) {
						prevstate = state;
					}
					if(zip!=null) {
						prevzip = zip;
					}
					AddressEntity newaddress = new AddressEntity(prevstreet, prevcity, prevstate, prevzip);
					employer.setAddress(newaddress);
				 return new ResponseEntity<EmployerEntity>(this.EmployerService.UpdateEmployer(employer), HttpStatus.OK);
			 }
		 }
	 }
	 
	 @RequestMapping(value = "employer/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 public ResponseEntity<?> deleteUser(
			 @PathVariable(required = true) Long id) {
//			 @RequestParam(value="id", required=true) long id){
		 if(this.EmployerService.EmployerExists(id)) {
			 return new ResponseEntity<>("Employer Cannot be deleted because it belongs to one or more employees currently",HttpStatus.BAD_REQUEST);
		 }
		 Optional<EmployerEntity> optionalemployer = this.EmployerService.DeleteEmployer(id);
		 if(!optionalemployer.isPresent()) {
			 return new ResponseEntity<>("Employer not Found",HttpStatus.NOT_FOUND);
		 } else {
			 EmployerEntity employer = optionalemployer.get();
			 return new ResponseEntity<EmployerEntity>(employer, HttpStatus.OK);
		 }
}
}
