package ItCareerElevatorFifthExcercise.listeners;

import ItCareerElevatorFifthExcercise.DTOs.UserLocationDTO;
import ItCareerElevatorFifthExcercise.services.interfaces.UserLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserLocationMessageListener {

    private final UserLocationService userLocationService;

    @KafkaListener(
            topics = "userLocation",
            groupId = "user-location-consumer",
            containerFactory = "userLocationKafkaListenerContainerFactory"
    )
    public void handleUserLocationMessage(UserLocationDTO userLocationDTO) {
        log.info("---> Handling message in the 'userLocation' topic.");

        if (userLocationDTO == null || userLocationDTO.getUserId() == null) {
            log.error("Invalid userLocationDTO: {}{}", System.lineSeparator(), userLocationDTO);
            return; // TODO: Should smth else happen?
        }

        log.info("Received data from Kafka: {}{}", System.lineSeparator(), userLocationDTO);
        userLocationService.persistUserLocation(userLocationDTO);
    }
}
