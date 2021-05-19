package com.parkingSystem.entity;
import org.springframework.stereotype.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
@Component
@RedisHash("parkingsystem")
public class Vehicle {

	@Id
	String id;
	String registrationNumber;
	String color;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
