package com.ticketgenerator.parkingsystem.controller;
import com.ticketgenerator.parkingsystem.entity.Vehicle;
import com.ticketgenerator.parkingsystem.service.ParkingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ParkingSystemController {

  @Autowired
  private ParkingSystemService parkingSystemService;

  //get all vehicle info
  @GetMapping("/vehicles")
  public List<Vehicle> displayVehicleInfo(){
    return parkingSystemService.displayVehicleDetails();
  }

  //add vehicle info
  @PostMapping("/vehicles")
  public ResponseEntity<Vehicle> addVehicleDetails(@RequestBody Vehicle vehicle) {
	  parkingSystemService.saveVehicleDetails(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
  }
  
  
  //update vehicle info
  @PutMapping("/vehicles/{id}")
	public Vehicle updateVehicleDetails(@PathVariable int id,@RequestBody Vehicle vehicle){
		      Vehicle vehicle1=this.parkingSystemService.updateVehicleDetails(id,vehicle);
		      return vehicle1;
  }
  //Delete vehicle info
  @DeleteMapping("/vehicles/{id}")
  public ResponseEntity<String> deleteVehicleInfoFromDatabase(@PathVariable int id){
    try {
      this.parkingSystemService.deleteVehicleDetails(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
