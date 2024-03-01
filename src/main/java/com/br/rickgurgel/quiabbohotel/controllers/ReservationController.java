package com.br.rickgurgel.quiabbohotel.controllers;

import com.br.rickgurgel.quiabbohotel.entities.Reservation;
import com.br.rickgurgel.quiabbohotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll(){
        List<Reservation> reservations = service.findAll();
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody Reservation reservation){
        service.insert(reservation);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservation.getId()).toUri();
        System.out.println(reservation);
        return ResponseEntity.created(uri).build();
    }
}
