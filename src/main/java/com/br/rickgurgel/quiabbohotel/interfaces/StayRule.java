package com.br.rickgurgel.quiabbohotel.interfaces;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;

public interface StayRule {
    Double calculateStay(Reservation r);
}
