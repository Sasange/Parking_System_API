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
  public HttpEntity<String> addVehicleInfoToDatabase(@RequestBody Vehicle vehicle){
    try {
      this.parkingSystemService.saveVehicleDetails(vehicle);
      return new ResponseEntity<>(HttpStatus.OK);

    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update vehicle info
  @PutMapping("/vehicles")
  public ResponseEntity<String> updateVehicleInfoInDatabase(@RequestBody Vehicle vehicle){
    try {
      this.parkingSystemService.updateVehicleDetails(vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //Delete vehicle info
  @DeleteMapping("/vehicles/{regNo}")
  public ResponseEntity<String> deleteVehicleInfoFromDatabase(@PathVariable String regNo){
    try {
      this.parkingSystemService.deleteVehicleDetails(regNo);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
