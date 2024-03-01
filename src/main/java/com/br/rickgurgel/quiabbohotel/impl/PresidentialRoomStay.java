package com.br.rickgurgel.quiabbohotel.impl;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.interfaces.StayRule;

public class PresidentialRoomStay implements StayRule {

    @Override
    public Double calculateStay(Reservation r){
        return 600.00 * r.getCheckout().compareTo(r.getCheckin());
    }

}
