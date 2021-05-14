package com.automatictg.example.services;

import org.springframework.stereotype.Service;

import com.automatictg.example.core.Slot;
import com.automatictg.example.core.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemorySlot implements SlotService {
private List<Vehicle> slotList;
private int floor;
private int space;
private int capacity;
private int totalSlotsOccupied;
private static String FAILED = "FAILED";
private static String SUCCEEDED = "SUCCEEDED";
private static String SLOT_NOT_FOUND_CODE = "slot.not.found";
private static String SLOT_NOT_FOUND_MESSAGE = "slot not found for this vehicle";


public InMemorySlot() {
	floor = 1;
	space = 3;
	capacity = floor*space;
	slotList = new ArrayList<>(capacity);
	for(int i = 0;i<capacity;i++){
		slotList.add(null);
	}
	totalSlotsOccupied = 0;
}

//@Override
//Slot printSlotDetails(String registrationNumber)
//{
//
//}

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
public Map addSlot(Vehicle vehicle) {
	int slotIndex = -1;
	Map resultMap = new HashMap();
	if(this.totalSlotsOccupied==this.capacity){
		return getErrorMap("slot.not.found","slot not found for this vehicle");
	}
	for(int i=0;i<capacity;i++)
	{
		if(slotList.get(i)==null){
			slotIndex = i;
			break;
		}
	}

	Slot slot = new Slot(vehicle,slotIndex);
	this.slotList.add(slotIndex,vehicle);
	System.out.println("slot : "+slot.getSlot());
	resultMap.put("registrationNumber",slot.getVehicle().getRegistrationNumber());
	resultMap.put("color",slot.getVehicle().getColor());
	resultMap.put("slot",slot.getSlot());
	resultMap.put("status",SUCCEEDED);
	this.totalSlotsOccupied++;
	return resultMap;
}


	@Override
	public Map removeSlot(int slotNumber)
	{
		if(slotNumber<0 || slotNumber>=capacity)
		{
			return getErrorMap("slot.number.invalid","this slot number is not valid");
		}
		if(this.slotList.get(slotNumber)==null){
			return getErrorMap("slot.already.empty","this slot is already vaccant");
		}
		this.slotList.add(slotNumber,null);
		this.totalSlotsOccupied--;
		Map resultMap = new HashMap();
		resultMap.put("message","slot removed successfully");
		resultMap.put("status",SUCCEEDED);
		return resultMap;
	}

	@Override
	public Map slotNumberByRegNumber(String regNumber)
	{
		Map <String,Object> resultMap = new HashMap<>();
		int slotNumber = -1;
		for(int i=0;i<capacity;i++){
			if(null!=slotList.get(i)){
				Vehicle car = slotList.get(i);
				if(car.getRegistrationNumber().equalsIgnoreCase(regNumber)){
					slotNumber = i;
				}
			}
		}
		if(slotNumber==-1){
			return getErrorMap("no.slot.found","no slot with found with this registration number");
		}
		resultMap.put("slotNumber",slotNumber);
		resultMap.put("status",SUCCEEDED);
		return resultMap;
	}

	@Override
	public Map slotNumbersByColor(String color)
	{
		List <Integer> slotNumbers = new ArrayList<>();
		Map resultMap = new HashMap();
		for(int i=0;i<capacity;i++){
			if(null!=slotList.get(i)){
				Vehicle car = slotList.get(i);
				if(car.getColor().equalsIgnoreCase(color)){
					slotNumbers.add(i);
				}
			}
		}
		if(slotNumbers.isEmpty()){
			return getErrorMap("no.slots.found.for.this.color","no slots found for this color");
		}
		resultMap.put("slot numbers",slotNumbers);
		resultMap.put("status",SUCCEEDED);
		return resultMap;
	}

//	@Override
//	public Map getAllSlots()
//	{
//		if(slotList.isEmpty()){
//			return getErrorMap("all.slots.empty","all.slots.empty");
//		}
//		List <Slot> AllSlots = new ArrayList<>();
//		for(int i=0;i<capacity;i++)
//		{
//
//		}
//
//	}

}
