package com.parkingSystem.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parkingSystem.entity.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

}
