package com.parkingSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.parkingSystem.entity.Vehicle;
import com.parkingSystem.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	// add vehicle
	@PostMapping(value = "/vehicles")
	public ResponseEntity<Vehicle> addVehicleDetails(@RequestBody Vehicle vehicle) {
		vehicleService.addVehicleDetails(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	// get all vehicle
	@GetMapping(value = "/vehicles")
	public List<Vehicle> getAllVehicle() {
		return vehicleService.getVehicleDetails();
	}
	
	//update vehicle
	//update
	@PutMapping("/vehicles/{id}")
	public Vehicle updateVehicleDetails(@PathVariable String id, @RequestBody Vehicle vehicle) {
		return this.vehicleService.updateVehicleDetails(id, vehicle);

	}
	
	//delete vehicle
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<String> deleteVehicleInfoFromDatabase(@PathVariable String id) {
		try {
			this.vehicleService.deleteVehicleDetails(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
