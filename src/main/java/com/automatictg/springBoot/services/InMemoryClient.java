package com.automatictg.springBoot.services;

import com.automatictg.springBoot.core.*;
import com.automatictg.springBoot.services.*;
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
public List<Vehicle> printDetails(){
	return list;
}

@Override
public Vehicle printDetails(String registrationNumber) {
	Vehicle vehicle = null;
	for(Vehicle details : list) {
		if(details.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
			vehicle = details;
			break;
		}
	}return vehicle;
}


@Override
public Vehicle addDetails(Vehicle vehicle) {
	list.add(vehicle);
	return vehicle;
	
}
@Override
public Vehicle updateDetails(Vehicle vehicle,String registrationNumber) {
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
public Vehicle deleteDetails(String registrationNumber) {
	Vehicle vehicle = null;
	for(Vehicle details : list) {
		if(details.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
			list.clear();
			break;
		}
	}return vehicle;
}
}
