package com.br.rickgurgel.quiabbohotel.enums;

import com.br.rickgurgel.quiabbohotel.impl.*;
import com.br.rickgurgel.quiabbohotel.interfaces.DiscountCalculator;
import com.br.rickgurgel.quiabbohotel.interfaces.StayRule;

public enum RoomType {

    SINGLE(new SingleRoomStay(new DiscountCalculatorImpl())),
    COUPLE(new CoupleRoomStay(new DiscountCalculatorImpl())),
    FAMILY(new FamilyRoomStay(new DiscountCalculatorImpl())),
    PRESIDENTIAL(new PresidentialRoomStay(new DiscountCalculatorImpl()));

    private final StayRule calcStay;

    RoomType(StayRule calcStay) {
        this.calcStay = calcStay;
    }

    public StayRule getCalcStay(){
        return calcStay;
    }
}
