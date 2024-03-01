package com.br.rickgurgel.quiabbohotel.impl;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.interfaces.CalcStay;

public class FamilyRoomStay implements CalcStay {

    @Override
    public Double calculateStay(Reservation r){
        return 350.00 * r.getCheckout().compareTo(r.getCheckin());
    }

}
