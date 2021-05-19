package com.parkingSystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkingSystem.entity.Vehicle;
import com.parkingSystem.repository.VehicleRepository;

@Service
public class VehicleServiceImplementation implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public List<Vehicle> getVehicleDetails() {
		
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@Override
	public Vehicle addVehicleDetails(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle updateVehicleDetails(String id, Vehicle vehicleDetails) {
		Optional<Vehicle> optionalVehicle=vehicleRepository.findById(id);
		Vehicle updateVehicle=optionalVehicle.get();
		updateVehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
		updateVehicle.setColor(vehicleDetails.getColor());
		vehicleRepository.save(updateVehicle);
		
		return updateVehicle;
	}

	@Override
	public Vehicle deleteVehicleDetails(String id) {
		Optional<Vehicle> deleteVehicle=vehicleRepository.findById(id);
		Vehicle deletedVehicle=deleteVehicle.get();
		vehicleRepository.delete(deletedVehicle);
		return deletedVehicle;
		
	}

}
