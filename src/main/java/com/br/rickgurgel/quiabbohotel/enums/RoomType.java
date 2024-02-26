package com.br.rickgurgel.quiabbohotel.enums;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE(200.0, 30),
    COUPLE(350.0, 25),
    FAMILY(500.0, 10),
    PRESIDENTIAL(750.0, 5);

    private final Double basePrice;
    private final Integer availability;

    RoomType(Double basePrice, Integer availability){
        this.basePrice = basePrice;
        this.availability = availability;
    }

}
