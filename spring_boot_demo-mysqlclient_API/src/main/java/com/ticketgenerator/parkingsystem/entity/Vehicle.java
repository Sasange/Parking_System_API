package com.ticketgenerator.parkingsystem.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name = "vehicle")
public class Vehicle {
  @Id
  @Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  
  int Id;
  @Column(name = "registrationNumber")
  private String registrationNumber;
  @Column(name = "Color")
  private String color;

  public Vehicle() {
  }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

  public Vehicle(String registrationNumber, String color) {
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
    return "\nVehicle Registration Number:" + registrationNumber + "\nVehicle Color:" + color;
  }



}

