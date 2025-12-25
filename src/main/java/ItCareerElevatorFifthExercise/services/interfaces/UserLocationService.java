package ItCareerElevatorFifthExercise.services.interfaces;

import ItCareerElevatorFifthExercise.DTOs.UserLocationDTO;
import ItCareerElevatorFifthExercise.entities.UserLocation;

public interface UserLocationService {

    void persistUserLocation(UserLocationDTO userLocationDTO);

    UserLocation save(UserLocation userLocation);
}
