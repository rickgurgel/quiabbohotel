package com.br.rickgurgel.quiabbohotel.impl;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.interfaces.CalcStay;

public class FamilyRoomStay implements CalcStay {

    @Override
    public Double calculateStay(Reservation r){
        return r.getRoomType().getBasePrice()
                * r.getCheckout().compareTo(r.getCheckin());
    }

}
