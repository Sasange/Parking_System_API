package com.parkingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import com.parkingSystem.entity.Vehicle;

@Service
public class VehicleServiceImplementation implements VehicleService{
	
	@Autowired
	private MongoRepository<Vehicle, String> mongoRepository;
	

	@Override
	public List<Vehicle> getVehicleDetails() {
		return mongoRepository.findAll();
	}

	@Override
	public Vehicle addVehicleDetails(Vehicle vehicle) {
		mongoRepository.save(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle updateVehicleDetails(String id, Vehicle vehicleDetails) {
		Optional<Vehicle> optionalVehicle=mongoRepository.findById(id);
		Vehicle updateVehicle=optionalVehicle.get();
		//todo
		System.out.println(updateVehicle.toString());
		
		updateVehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
		updateVehicle.setColor(vehicleDetails.getColor());
		mongoRepository.save(updateVehicle);
		
		return updateVehicle;
 
		
	}

	
	public Vehicle deleteVehicleDetails(String id)  {
		Optional<Vehicle> entity=mongoRepository.findById(id);
		Vehicle vehicle=entity.get();
		mongoRepository.delete(vehicle);

		return vehicle;
		
	}
}

