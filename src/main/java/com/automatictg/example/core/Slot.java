package com.automatictg.example.core;

public class Slot {
	private Vehicle vehicle;
	private int slot;

	public Slot(Vehicle vehicle, int slot) {
		this.vehicle = vehicle;
		this.slot = slot;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}
