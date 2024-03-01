package com.br.rickgurgel.quiabbohotel.impl;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.interfaces.DiscountCalculator;
import com.br.rickgurgel.quiabbohotel.interfaces.StayRule;

public class FamilyRoomStay implements StayRule {

    private final DiscountCalculator discount;

    public FamilyRoomStay(DiscountCalculator discount) {
        this.discount = discount;
    }

    @Override
    public Double calculateStay(Reservation r){
        Double basePrice = 350.00;
        Integer daysOfStaying = r.getCheckout().compareTo(r.getCheckin());
        return discount.applyDiscount(basePrice, daysOfStaying);
    }
}
