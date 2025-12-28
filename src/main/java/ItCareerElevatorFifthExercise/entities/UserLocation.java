package ItCareerElevatorFifthExercise.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users_locations", schema = "messaging_geospatial")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String username;

    @Column
    private String recordedAt; // For reading data convenience: 25/12/2025 23:47

    @Column(name = "geom", columnDefinition = "geometry(Point,4326)") // EPSG:4326, “WGS 84”
    private Point geometry;

    public UserLocation(String userId, String username, Point geometry, String recordedAt) {
        this.userId = userId;
        this.username = username;
        this.geometry = geometry;
        this.recordedAt = recordedAt;
    }
}
