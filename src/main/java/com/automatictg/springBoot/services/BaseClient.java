package com.automatictg.springBoot.services;

import com.automatictg.springBoot.core.*;
import java.util.*;

public interface BaseClient {
List<Vehicle> printDetails();

Vehicle printDetails(String registrationNumber);
Vehicle addDetails(Vehicle vehicle);
Vehicle updateDetails(Vehicle vehicle,String registrationNumber);
Vehicle deleteDetails(String registrationNumber);
}
