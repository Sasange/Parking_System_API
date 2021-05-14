package com.automatictg.example.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String registrationNumber;
  private String color;

  protected Vehicle() {}


public Vehicle( String registrationNumber, String color) {
	super();
	this.registrationNumber = registrationNumber;
	this.color = color;
}


public String getRegistrationNumber() {
	return registrationNumber;
}

public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}


@Override
public String toString() {
	return "Vehicle [id=" + id + ", registrationNumber=" + registrationNumber + ", color=" + color + "]";
}

  
}