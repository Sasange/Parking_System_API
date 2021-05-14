package com.automatictg.example.controller;

import java.util.*;

import com.automatictg.example.core.*;
import com.automatictg.example.services.*;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingSystemController {
	
@Autowired
BaseClient baseClient;


//get all vehicle details

@GetMapping("/vehicle")
public List<Vehicle> vehicleDetails()
{
	return baseClient.displayVehicleDetails();
}

//get vehicle details using registration number
@GetMapping ("/vehicle/{registrationNumber}")
public Vehicle vehicleDetails(@PathVariable String registrationNumber) {
	
	return this.baseClient.displayVehicleDetails(registrationNumber);
}

@GetMapping ("/vehicles_With_Given_Color/{color}")
public Map vehiclesWithGivenRegNo(@PathVariable String color) {
	return this.baseClient.getAllCarsWithGivenColor(color);
}

@PostMapping("/vehicle")
public Vehicle addVehicle(@RequestBody Map <String,String> requestMap) {
	Vehicle vehicle = new Vehicle(requestMap.get("registrationNumber"),requestMap.get("color"));
	return this.baseClient.saveVehicleDetails(vehicle);
}

//update vehicle details 
@PutMapping ("/vehicle/{regitrationNumber}")
public Vehicle updateVehicleDetails(@RequestBody Vehicle vehicle,@PathVariable String registrationNumber) {
	return this.baseClient.updateVehicleDetails(vehicle, registrationNumber);
}
//delete vehicle details 
@DeleteMapping ("/vehicle/{registrationNumber}")
public Vehicle deleteVehicle(@PathVariable String registrationNumber) {
return this.baseClient.deleteVehicleDetails(registrationNumber);	
}
}
