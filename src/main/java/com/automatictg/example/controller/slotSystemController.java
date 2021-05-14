package com.automatictg.example.controller;

import com.automatictg.example.core.Vehicle;
import com.automatictg.example.services.BaseClient;
import com.automatictg.example.services.SlotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class slotSystemController {
	
    @Autowired
    SlotService slotService;

    @PostMapping("/addSlot")
    public Map addSlot(@RequestBody Map <String,String> requestMap) {
        Vehicle vehicle = new Vehicle(requestMap.get("registrationNumber"),requestMap.get("color"));
        return this.slotService.addSlot(vehicle);
    }

    @GetMapping ("/slot_Number_With_Given_Reg_No/{registrationNumber}")
    public Map vehiclesWithGivenRegNo(@PathVariable String registrationNumber) {
        return this.slotService.slotNumberByRegNumber(registrationNumber);
    }

    @GetMapping ("/slot_Numbers_With_Given_Color/{color}")
    public Map slotNumbersWithGivenColor(@PathVariable String color) {
        return this.slotService.slotNumbersByColor(color);
    }

    @PostMapping("/removeSlot")
    public Map removeSlot(@RequestBody Map <String,String> requestMap) {
        int slotNumber = Integer.parseInt(requestMap.get("slotNumber"));
        return this.slotService.removeSlot(slotNumber);
    }

}
