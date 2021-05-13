package com.automatictg.example.core;

import java.util.ArrayList;

public class Slot {
public static Vehicle[] parkingSlots;
private Integer floorNumber;
private Integer spaceOnEachFloor;
private Integer capacity;



public Slot(Integer floorNumber, Integer spaceOnEachFloor) {
	super();
	this.floorNumber = floorNumber;
	this.spaceOnEachFloor = spaceOnEachFloor;
	Slot.parkingSlots = new Vehicle[floorNumber * spaceOnEachFloor];

}


public static Vehicle[] getParkingSlots() {
	return parkingSlots;
}
public static void setParkingSlots(Vehicle[] parkingSlots) {
	Slot.parkingSlots = parkingSlots;
}
public Integer getFloorNumber() {
	return floorNumber;
}
public void setFloorNumber(Integer floorNumber) {
	this.floorNumber = floorNumber;
}
public Integer getSpaceOnEachFloor() {
	return spaceOnEachFloor;
}
public void setSpaceOnEachFloor(Integer spaceOnEachFloor) {
	this.spaceOnEachFloor = spaceOnEachFloor;
}
public Integer getCapacity() {
	return capacity;
}
public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}
@Override
public String toString() {
	return "Slot [floorNumber=" + floorNumber + ", spaceOnEachFloor=" + spaceOnEachFloor + ", capacity=" + capacity
			+ "]";
}




}
