package com.ticketgenerator.parkingsystem.service;

import com.ticketgenerator.parkingsystem.entity.Vehicle;
import com.ticketgenerator.parkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingSystemServiceImplementation implements ParkingSystemService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public List<Vehicle> displayVehicleDetails() {
    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle saveVehicleDetails(Vehicle vehicle) {
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateVehicleDetails(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @Override
  public void deleteVehicleDetails(String regNo) {
    Vehicle entity=vehicleRepository.getOne(regNo);
    vehicleRepository.delete(entity);
  }

}
