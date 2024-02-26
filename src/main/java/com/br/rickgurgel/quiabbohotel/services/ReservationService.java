package com.br.rickgurgel.quiabbohotel.services;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.repositories.ReservationRepository;
import com.br.rickgurgel.quiabbohotel.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(UUID id){
        return Optional.ofNullable(reservationRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Reservation not found")
                ));
    }

    public String insert(Reservation reservation){
        reservationRepository.save(reservation);
        return "Reservation made: " + reservation.toString();
    }

    public String update(Reservation reservation){
        Optional<Reservation> newReservation = findById(reservation.getId());
        updateReservation(newReservation, reservation);
        reservationRepository.save(newReservation.get());
        return "Reservation updated" + newReservation.get().toString();
    }

    private void updateReservation(Optional<Reservation> newReservation, Reservation reservation){
        newReservation.get().setCheckin(reservation.getCheckin());
        newReservation.get().setCheckout(reservation.getCheckout());
        newReservation.get().setRoomType(reservation.getRoomType());
        newReservation.get().setStayValue(reservation.getStayValue());
    }

}
