package com.br.rickgurgel.quiabbohotel.impl;

import com.br.rickgurgel.quiabbohotel.interfaces.DiscountCalculator;

public class DiscountCalculatorImpl implements DiscountCalculator {

    @Override
    public Double applyDiscount(Double basePrice, Integer daysOfStaying) {
        if (daysOfStaying > 15) {
            return basePrice * daysOfStaying * 0.85;
        } else if (daysOfStaying > 10) {
            return basePrice * daysOfStaying * 0.90;
        } else if (daysOfStaying > 5) {
            return basePrice * daysOfStaying * 0.95;
        } else {
            return basePrice * daysOfStaying;
        }
    }
}
