package com.ticketgenerator.parkingsystem.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
  @Id
  private String registrationNumber;
  private String color;

  public Vehicle() {
  }

  public Vehicle(String registrationNumber, String color) {
    this.registrationNumber = registrationNumber;
    this.color = color;
  }

  public String getRegNo() {
    return registrationNumber;
  }
  public void setRegNo(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }
  public String getColour() {
    return color;
  }
  public void setColour(String colour) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "\nVehicle Registration Number:" + registrationNumber + "\nVehicle Color:" + color;
  }



}

