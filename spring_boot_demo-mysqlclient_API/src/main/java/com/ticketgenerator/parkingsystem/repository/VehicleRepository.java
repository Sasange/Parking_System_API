package com.ticketgenerator.parkingsystem.repository;
import com.ticketgenerator.parkingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

}
