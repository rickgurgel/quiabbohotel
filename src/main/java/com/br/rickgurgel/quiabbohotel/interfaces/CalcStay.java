package com.br.rickgurgel.quiabbohotel.interfaces;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import org.springframework.stereotype.Service;

public interface CalcStay {
    Double calculateStay(Reservation r);
}
