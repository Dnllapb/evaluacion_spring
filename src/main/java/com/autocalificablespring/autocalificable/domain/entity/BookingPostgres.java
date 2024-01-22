package com.autocalificablespring.autocalificable.domain.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema ="booking")
public class BookingPostgres {

    @Id
    @SequenceGenerator(
            name = "booking_id_sequence",
            sequenceName = "booking_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_id_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private String origin;
    private String destination;
    private Date departureDate;

    private Date departureTime;
    private String duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingPostgres that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
