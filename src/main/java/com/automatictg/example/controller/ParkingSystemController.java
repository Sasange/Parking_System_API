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

@GetMapping("/Vehicle")
public List<Vehicle> vehicleDetails()
{
	return baseClient.displayVehicleDetails();
}

//get vehicle details using registration number
@GetMapping ("/vehicle/{registrationNumber}")
public Vehicle vehicleDetails(@PathVariable String registrationNumber) {
	
	return this.baseClient.displayVehicleDetails(registrationNumber);
}

@PostMapping("/Vehicle")
public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
	return this.baseClient.saveVehicleDetails(vehicle);
}

//update vehicle details 
@PutMapping ("/Vehicle/{regitrationNumber}")
public Vehicle updateVehicleDetails(@RequestBody Vehicle vehicle,@PathVariable String registrationNumber) {
	return this.baseClient.updateVehicleDetails(vehicle, registrationNumber);
}
//delete vehicle details 
@DeleteMapping ("/Vehicle/{registrationNumber}")
public Vehicle deleteVehicle(@PathVariable String registrationNumber) {
return this.baseClient.deleteVehicleDetails(registrationNumber);	
}


}
