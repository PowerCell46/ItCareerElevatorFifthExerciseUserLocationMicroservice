package ItCareerElevatorFifthExercise.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static String formatGeolocationTimestamp(Long epochMillis) {
        if (epochMillis == null) {
            return null;
        }

        Instant instant = Instant.ofEpochMilli(epochMillis);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(
                instant,
                ZoneId.systemDefault() // or ZoneId.of("Europe/Sofia")
        );

        return localDateTime.format(FORMATTER);
    }
}
