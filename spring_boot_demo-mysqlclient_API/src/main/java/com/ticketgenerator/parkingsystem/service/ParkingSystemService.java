package com.ticketgenerator.parkingsystem.service;
import com.ticketgenerator.parkingsystem.entity.Vehicle;

import java.util.List;


public interface ParkingSystemService {
  List<Vehicle> displayVehicleDetails();

  Vehicle saveVehicleDetails(Vehicle vehicle);

  Vehicle updateVehicleDetails(int id,Vehicle vehicle);

  void deleteVehicleDetails(int id);
}
