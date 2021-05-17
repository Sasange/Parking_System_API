package com.ticketgenerator.parkingsystem.service;
import com.ticketgenerator.parkingsystem.entity.Vehicle;

import java.util.List;


public interface ParkingSystemService {
  List<Vehicle> displayVehicleDetails();

  Vehicle saveVehicleDetails(Vehicle vehicle);

  Vehicle updateVehicleDetails(Vehicle vehicle);

  void deleteVehicleDetails(String regNo);
}
