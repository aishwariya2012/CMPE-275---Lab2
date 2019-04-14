package com.assignment.lab2.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	@JsonProperty("Name")
    private String name;
	
	@Column
	@JsonProperty("Email")
    private String email;
	
	@Column
	@JsonProperty("Title")
    private String title;
	
		
	@Embedded
	@JsonProperty("Address")
    private AddressEntity address;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	@JsonIgnoreProperties(value = {"Description","Address"})
	private EmployerEntity employer;
    
    
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="manager_id",referencedColumnName="id")
    private Employee manager;	
	
	//@Column
	@OneToMany(mappedBy="manager")
    private List<Employee> reports;
  
	@ManyToMany
	@JoinTable(
			joinColumns={@JoinColumn(name="id")},
			inverseJoinColumns={@JoinColumn(name="collab_id")})
	@JsonIgnoreProperties(value = {""})
	private List<Employee> collaborators;
    
    
   
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public EmployerEntity getEmployer() {
		return employer;
	}
	public void setEmployer(EmployerEntity employer) {
		this.employer = employer;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	  public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
	public Employee(String name, String email, String title, AddressEntity address, EmployerEntity employer,
			Employee manager, long id) {
		super();
		this.name = name;
		this.email = email;
		this.title = title;
		this.address = address;
		this.employer = employer;
		this.manager = manager;
		
		this.id = id;
	}
	  
	
}
