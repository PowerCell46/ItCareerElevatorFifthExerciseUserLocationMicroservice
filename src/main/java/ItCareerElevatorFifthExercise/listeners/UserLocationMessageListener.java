package ItCareerElevatorFifthExercise.listeners;

import ItCareerElevatorFifthExercise.DTOs.UserLocationDTO;
import ItCareerElevatorFifthExercise.services.interfaces.UserLocationService;
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
            topics = "${spring.kafka.topic.user-location:userLocation}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "userLocationKafkaListenerContainerFactory"
    )
    public void handleUserLocationMessage(UserLocationDTO userLocationDTO) {
        log.info("---> Handling message in the Kafka topic.");

        if (userLocationDTO == null || userLocationDTO.getUserId() == null) {
            log.error("Invalid userLocationDTO received: {}", userLocationDTO);
            return;
        }

        log.info("Received data from Kafka: {}", userLocationDTO);
        userLocationService.persistUserLocation(userLocationDTO);
    }
}
