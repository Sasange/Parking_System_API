package com.automatictg.example.services;

import java.util.List;
import java.util.Map;

import com.automatictg.example.core.Slot;
import com.automatictg.example.core.Vehicle;

public interface SlotService {


Map addSlot(Vehicle vehicle);
Map removeSlot(int slotNumber);
public Map slotNumberByRegNumber(String regNumber);
public Map slotNumbersByColor(String color);


}
