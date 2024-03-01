package com.br.rickgurgel.quiabbohotel.services;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import org.springframework.stereotype.Service;

public class CalculateStay {
    public Double stay(Reservation reservation){
        return reservation.getRoomType().getCalcStay().calculateStay(reservation);
    }

}