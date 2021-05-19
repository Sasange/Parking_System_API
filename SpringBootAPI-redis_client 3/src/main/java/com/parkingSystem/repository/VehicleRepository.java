package com.parkingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parkingSystem.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String>  {

}
