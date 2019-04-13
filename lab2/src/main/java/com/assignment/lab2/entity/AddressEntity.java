package com.assignment.lab2.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Access;
import javax.persistence.AccessType;



@Embeddable @Access(AccessType.FIELD)
public class AddressEntity {
	
	@Column
	private String street;
	@Column
    private String city;
	
	@Column
    private String state;
	@Column
    private String zip;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public AddressEntity() {
		super();
	}
	public AddressEntity(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	


}





