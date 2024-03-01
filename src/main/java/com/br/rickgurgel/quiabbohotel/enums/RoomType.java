package com.br.rickgurgel.quiabbohotel.enums;

import com.br.rickgurgel.quiabbohotel.impl.CoupleRoomStay;
import com.br.rickgurgel.quiabbohotel.impl.FamilyRoomStay;
import com.br.rickgurgel.quiabbohotel.impl.PresidentialRoomStay;
import com.br.rickgurgel.quiabbohotel.impl.SingleRoomStay;
import com.br.rickgurgel.quiabbohotel.interfaces.StayRule;

public enum RoomType {

    SINGLE(new SingleRoomStay()),
    COUPLE(new CoupleRoomStay()),
    FAMILY(new FamilyRoomStay()),
    PRESIDENTIAL(new PresidentialRoomStay());

    private final StayRule calcStay;

    RoomType(StayRule calcStay) {
        this.calcStay = calcStay;
    }

    public StayRule getCalcStay(){
        return calcStay;
    }
}
