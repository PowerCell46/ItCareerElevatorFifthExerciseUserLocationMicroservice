package ItCareerElevatorFifthExcercise.services.interfaces;

import ItCareerElevatorFifthExcercise.DTOs.UserLocationDTO;
import ItCareerElevatorFifthExcercise.entities.UserLocation;

public interface UserLocationService {

    void persistUserLocation(UserLocationDTO userLocationDTO);

    UserLocation save(UserLocation userLocation);
}
