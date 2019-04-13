package com.assignment.lab2.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

public class EmployerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	


	@Column
	@JsonIgnoreProperties({"Name"})
	@JsonProperty("Name")
    private String name;
	
	@Column
    private String description;
	
    @Embedded
    private AddressEntity address;
    
    

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public EmployerEntity(long id, String name, String description, AddressEntity address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
	}

	public EmployerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployerEntity(String name, String description, AddressEntity address) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
	}


}
