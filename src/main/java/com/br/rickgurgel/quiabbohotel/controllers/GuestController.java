package com.br.rickgurgel.quiabbohotel.controllers;

import com.br.rickgurgel.quiabbohotel.entities.Guest;
import com.br.rickgurgel.quiabbohotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> findAll(){
        List<Guest> guestList = guestService.findAll();
        return ResponseEntity.ok().body(guestList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(findById(id).getBody());
    }

    @PutMapping("/insert-guest")
    public ResponseEntity<Void> insert(@RequestBody Guest guest){
        guestService.insert(guest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(guest.getId()).toUri();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Guest guest, @PathVariable UUID id){
        Guest newGuest = findById(guest.getId()).getBody();
        newGuest.setId(id);
        newGuest = guestService.update(guest);
        return ResponseEntity.noContent().build();
    }
}
