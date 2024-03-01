package com.br.rickgurgel.quiabbohotel.services;

import com.br.rickgurgel.quiabbohotel.entities.Guest;
import com.br.rickgurgel.quiabbohotel.repositories.GuestRepository;
import com.br.rickgurgel.quiabbohotel.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAll(){
        return guestRepository.findAll();
    }

    public Optional<Guest> findById(Long id){
        return guestRepository.findById(id);
    }

    public Guest insert(Guest guest){
        // You can directly return the saved guest
        return guestRepository.save(guest);
    }

    public void delete(Long id){
        guestRepository.deleteById(id);
    }

    public Guest update(Guest guest, Long id){
        // Check if the guest exists before updating
        Optional<Guest> existingGuestOptional = guestRepository.findById(id);
        if(existingGuestOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found");
        }

        // Update the guest details
        Guest existingGuest = existingGuestOptional.get();
        existingGuest.setName(guest.getName());
        existingGuest.setSocialRegister(guest.getSocialRegister());
        existingGuest.setEmail(guest.getEmail());
        existingGuest.setPhone(guest.getPhone());

        // Save and return the updated guest
        return guestRepository.save(existingGuest);
    }
}
