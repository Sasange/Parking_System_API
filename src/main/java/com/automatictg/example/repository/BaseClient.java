package com.automatictg.example.repository;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import com.automatictg.example.core.*;

public interface BaseClient {
List<Vehicle> displayVehicleDetails();

Vehicle displayVehicleDetails(String registrationNumber);
Vehicle saveVehicleDetails(Vehicle vehicle);
Vehicle updateVehicleDetails(Vehicle vehicle,String registrationNumber);
Vehicle deleteVehicleDetails(String registrationNumber);
}
