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

//    @Column(nullable = false)
//    private String username;

    @Column(nullable = false)
    private String userId;

    @Column
    private String recordedAt; // 25/12/2025 23:47

    @Column(name = "geom", columnDefinition = "geometry(Point,4326)")
    private Point geom;

    public UserLocation(String userId, String recordedAt, Point geom) {
        this.userId = userId;
        this.recordedAt = recordedAt;
        this.geom = geom;
    }
}
