package com.automatictg.example.services;

import java.util.*;

import com.automatictg.example.core.*;

public interface BaseClient {
List<Vehicle> displayVehicleDetails();

Vehicle displayVehicleDetails(String registrationNumber);
Vehicle saveVehicleDetails(Vehicle vehicle);
Vehicle updateVehicleDetails(Vehicle vehicle,String registrationNumber);
Vehicle deleteVehicleDetails(String registrationNumber);
public Map getAllCarsWithGivenColor(String color);
}
