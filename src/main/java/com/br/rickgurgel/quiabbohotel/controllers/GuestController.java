package com.br.rickgurgel.quiabbohotel.controllers;

import com.br.rickgurgel.quiabbohotel.entities.Guest;
import com.br.rickgurgel.quiabbohotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<Guest> findById(@PathVariable Long id){
        Guest guest = guestService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found"));
        return ResponseEntity.ok().body(guest);
    }

    @PostMapping("/insert") // Change to @PostMapping
    public ResponseEntity<Guest> insert(@RequestBody Guest guest){ // Change return type to ResponseEntity<Guest>
        Guest savedGuest = guestService.insert(guest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedGuest.getId()).toUri();
        return ResponseEntity.created(location).body(savedGuest); // Return ResponseEntity with created location and saved guest
    }

    @DeleteMapping("/{id}") // Change to @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){ // Change return type to ResponseEntity<Void>
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}") // Change to @PutMapping
    public ResponseEntity<Guest> update(@RequestBody Guest guest, @PathVariable Long id){
        Guest updatedGuest = guestService.update(guest, id);
        return ResponseEntity.ok().body(updatedGuest);
    }
}
