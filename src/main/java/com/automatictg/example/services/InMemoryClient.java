package com.automatictg.example.services;

import com.automatictg.example.core.*;
import com.automatictg.example.services.*;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class InMemoryClient implements BaseClient {
List<Vehicle> list;

public InMemoryClient() {
	list=new ArrayList<>();
	list.add(new Vehicle("mh49aa1234","white"));
	list.add(new Vehicle("mh31ss7890","grey"));
	
}
@Override
public List<Vehicle> displayVehicleDetails(){
	return list;
}

@Override
public Vehicle displayVehicleDetails(String registrationNumber) {
	Vehicle vehicle = null;
	for(Vehicle details : list) {
		if(details.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
			vehicle = details;
			break;
		}
	}return vehicle;
}


@Override
public Vehicle saveVehicleDetails(Vehicle vehicle) {
	list.add(vehicle);
	return vehicle;
	
}
@Override
public Vehicle updateVehicleDetails(Vehicle vehicle,String registrationNumber) {
	for(Vehicle details : list)
	{
		if(details.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
			details.setRegistrationNumber(vehicle.getRegistrationNumber());
			details.setColor(vehicle.getColor());
			break;
			
		}
	}return vehicle;
}

@Override
public Vehicle deleteVehicleDetails(String registrationNumber) {
	Vehicle vehicle = null;
	for(Vehicle details : list) {
		if(details.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
			list.clear();
			break;
		}
	}return vehicle;
}
}
