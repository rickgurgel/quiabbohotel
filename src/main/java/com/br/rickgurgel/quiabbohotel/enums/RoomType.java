package com.br.rickgurgel.quiabbohotel.enums;

import com.br.rickgurgel.quiabbohotel.impl.CoupleRoomStay;
import com.br.rickgurgel.quiabbohotel.impl.FamilyRoomStay;
import com.br.rickgurgel.quiabbohotel.impl.SingleRoomStay;
import com.br.rickgurgel.quiabbohotel.interfaces.CalcStay;

public enum RoomType {

    SINGLE(new SingleRoomStay()),
    COUPLE(new CoupleRoomStay()),
    FAMILY(new FamilyRoomStay()),
    PRESIDENTIAL(new FamilyRoomStay());

    private final CalcStay calcStay;

    RoomType(CalcStay calcStay) {
        this.calcStay = calcStay;
    }

    public CalcStay getCalcStay(){
        return calcStay;
    }
}
