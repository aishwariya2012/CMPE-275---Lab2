package com.assignment.lab2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.assignment.lab2.service.CollaboratorService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CollaboratorController {
	
	@Autowired
	CollaboratorService cs;
	

	@RequestMapping(value = "/collaborators/{id1}/{id2}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> CollaboratorsAddition(
    @PathVariable(required = true) Long id1,
    @PathVariable(required = true) Long id2
    ){
		if(cs.EmployeeCheck(id1, id2)) {
			if(cs.CollaborationCheck(id1, id1)) {
				return new ResponseEntity<>("Already Collaborated",HttpStatus.OK);
			}
			else {
				cs.CollaboratorsAddition(id1, id2);
				return new ResponseEntity<>("Collaboraters add",HttpStatus.OK);
			}
		}
		else {
			return new ResponseEntity<>("Employess Not Found",HttpStatus.NOT_FOUND);
		}
		
}
	

	@RequestMapping(value = "/collaborators/{id1}/{id2}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> CollaboratorsDeletion(
    @PathVariable(required = true) Long id1,
    @PathVariable(required = true) Long id2
    ){
		if(cs.EmployeeCheck(id1, id2)) {
			if(!cs.CollaborationCheck(id1, id2)) {
				return new ResponseEntity<>("Not Collaborated Relation",HttpStatus.NOT_FOUND);
			}
			else {
				cs.CollaboratorsDeletion(id1, id2);
				return new ResponseEntity<>("Collaboraters Deleted",HttpStatus.OK);
			}
		}
		else {
			return new ResponseEntity<>("Employess Not Found",HttpStatus.NOT_FOUND);
		}
		
}
}

