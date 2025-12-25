package ItCareerElevatorFifthExcercise.services.implementations;

import ItCareerElevatorFifthExcercise.DTOs.UserLocationDTO;
import ItCareerElevatorFifthExcercise.entities.UserLocation;
import ItCareerElevatorFifthExcercise.repositories.UserLocationRepository;
import ItCareerElevatorFifthExcercise.services.interfaces.UserLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserLocationServiceImpl implements UserLocationService {

    private static final Integer SPATIAL_REFERENCE_SYSTEM_IDENTIFIER = 4326; // EPSG:4326, “WGS 84”

    private final UserLocationRepository userLocationRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), SPATIAL_REFERENCE_SYSTEM_IDENTIFIER);

    @Override
    public void persistUserLocation(UserLocationDTO userLocationDTO) {
        Point point = initializePoint(userLocationDTO.getLongitude(), userLocationDTO.getLatitude());

        UserLocation entity = new UserLocation(userLocationDTO.getUserId(), "", point);
        save(entity);
    }

    private Point initializePoint(Double longitude, Double latitude) {
        Coordinate coordinate = new Coordinate(longitude, latitude);
        return geometryFactory.createPoint(coordinate);
    }

    @Override
    public UserLocation save(UserLocation userLocation) {
        log.info("Persisting location for user {}.", userLocation.getUserId());

        return userLocationRepository.save(userLocation);
    }
}
