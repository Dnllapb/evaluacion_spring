package com.autocalificablespring.autocalificable.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Document(collection = "booking")
@Data
public class BookingMongo {

    @Id
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
        if (!(o instanceof BookingMongo that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getOrigin(), that.getOrigin()) && Objects.equals(getDestination(), that.getDestination()) && Objects.equals(getDepartureDate(), that.getDepartureDate()) && Objects.equals(getDepartureTime(), that.getDepartureTime()) && Objects.equals(getDuration(), that.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getOrigin(), getDestination(), getDepartureDate(), getDepartureTime(), getDuration());
    }
}

