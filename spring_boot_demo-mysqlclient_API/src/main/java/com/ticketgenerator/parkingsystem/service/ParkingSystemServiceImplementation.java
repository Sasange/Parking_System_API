package com.ticketgenerator.parkingsystem.service;

import com.ticketgenerator.parkingsystem.entity.Vehicle;
import com.ticketgenerator.parkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class ParkingSystemServiceImplementation implements ParkingSystemService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public List<Vehicle> displayVehicleDetails() {
//    return vehicleRepository.findAll();
    return (List<Vehicle>) vehicleRepository.findAll();
  }

  @Override
  public Vehicle saveVehicleDetails(Vehicle vehicle) {
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  @Override
	public Vehicle updateVehicleDetails(int id,Vehicle vehicleDetails) {
		Optional<Vehicle> optionalVehicle=vehicleRepository.findById(id);
		Vehicle vehicle=optionalVehicle.get();
		vehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
		vehicle.setColor(vehicleDetails.getColor());
		vehicleRepository.save(vehicle);
		return vehicle;
	}

  @Override
  public void deleteVehicleDetails(int id) {
    Vehicle entity=vehicleRepository.getOne(id);
    vehicleRepository.delete(entity);
  }

}
