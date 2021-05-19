package com.parkingSystem.service;

import java.util.List;

import com.parkingSystem.entity.Vehicle;

public interface VehicleService {
	
	List<Vehicle> getVehicleDetails();

	Vehicle addVehicleDetails(Vehicle vehicle);

	Vehicle updateVehicleDetails(String id,Vehicle vehicle);

	Vehicle deleteVehicleDetails(String id);

}
