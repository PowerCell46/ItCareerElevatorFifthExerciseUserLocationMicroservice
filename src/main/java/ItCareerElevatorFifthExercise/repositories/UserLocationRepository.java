package ItCareerElevatorFifthExercise.repositories;

import ItCareerElevatorFifthExercise.entities.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, String> {
}
