package com.automatictg.example.services;

import com.automatictg.example.core.*;
import com.automatictg.example.services.*;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Service
public class InMemoryClient implements BaseClient {
	List<Vehicle> list;
	private static String FAILED = "FAILED";
	private static String SUCCEEDED = "SUCCEEDED";
	private static String CARS_NOT_FOUND = "car.not.found";
	private static String CARS_NOT_FOUND_MESSAGE = "no cars found with given color";

public InMemoryClient() {
	list=new ArrayList<>();
//	list.add(new Vehicle("mh49aa1234","white"));
//	list.add(new Vehicle("mh31ss7890","grey"));
	
}

private Map getErrorMap(String code,String message)
{
	Map errorMap = new HashMap();
	errorMap.put("status",FAILED);
	Map error = new HashMap();
	error.put("errorCode",code);
	error.put("errorMessage",message);
	errorMap.put("error",error);
	System.out.println("error : "+ errorMap);
	return errorMap;
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
	System.out.println("vehicle reg no : " + vehicle.getRegistrationNumber());
	System.out.println("vehicle color  : " + vehicle.getColor());
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

@Override
public Map getAllCarsWithGivenColor(String color){
	List <String> carList = new ArrayList();
	Map <String,Object> resultMap = new HashMap();
	for(int i= 0;i<list.size();i++)
	{
		Vehicle car = list.get(i);
		if(car.getColor().equalsIgnoreCase(color))
			carList.add(car.getRegistrationNumber());
	}
	if(list.size()==0){
		return getErrorMap("car.not.found","no cars found with given color");
	}

	resultMap.put("color",color);
	resultMap.put("registration numbers",carList);
	resultMap.put("status",SUCCEEDED);
	return resultMap;
}

}
