package com.br.rickgurgel.quiabbohotel.entities;

import com.br.rickgurgel.quiabbohotel.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne
    private Guest guest;
    private RoomType roomType;
    private LocalDate checkin;
    private LocalDate checkout;
    private Double stayValue;

    public Reservation(Guest guest, RoomType roomType, LocalDate checkin, LocalDate checkout) {
        this.guest = guest;
        this.roomType = roomType;
        this.checkin = checkin;
        this.checkout = checkout;
    }

}
