package racejournal.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alaplante on 2/9/16.
 */
@Entity
@Table(name = "race_results")
@SequenceGenerator(
        name = "RACE_RESULT_SEQ_GENERATOR",
        sequenceName = "RACE_RESULT_SEQ",
        initialValue = 1, allocationSize = 1)
public class RaceResult {
    // ref to rider
    // ref to race
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RACE_RESULT_SEQ_GENERATOR")
    @Column(name = "id")
    private Long id;
    private Long placing;
    @Column(name = "field_size")
    private Long fieldSize;
    @Column(name = "race_result_type")
    private RaceResultType raceResultType;
    private String description;

    @ManyToOne
    @JoinColumn(name="rider_id")
    Rider rider;

    @ManyToOne
    @JoinColumn(name="race_id")
    Race race; // get name, date, etc from race


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlacing() {
        return placing;
    }

    public void setPlacing(Long placing) {
        this.placing = placing;
    }

    public Long getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(Long fieldSize) {
        this.fieldSize = fieldSize;
    }

    public RaceResultType getRaceResultType() {
        return raceResultType;
    }

    public void setRaceResultType(RaceResultType raceResultType) {
        this.raceResultType = raceResultType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return String.format("RaceResult[id=%s, placing='%s', fieldSize=%s, raceResultType='%s', description='%s']",
                id, placing, fieldSize, raceResultType, description);
    }
}
