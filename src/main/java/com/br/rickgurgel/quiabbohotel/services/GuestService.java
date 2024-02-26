package com.br.rickgurgel.quiabbohotel.services;

import com.br.rickgurgel.quiabbohotel.entities.Guest;
import com.br.rickgurgel.quiabbohotel.repositories.GuestRepository;
import com.br.rickgurgel.quiabbohotel.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAll(){
        return guestRepository.findAll();
    }

    public Optional<Guest> findById(UUID id){
        return Optional.ofNullable(guestRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Guest not found")
        ));
    }

    public String insert(Guest guest){
        guestRepository.save(guest);
        return "Guest inserted" + guest.toString();
    }

    public String delete(UUID id){
        findById(id);
        delete(id);
        return "Guest deleted" + guestRepository.findById(id);
    }

    private String update(Guest guest){
        Optional<Guest> newGuest = findById(guest.getId());
        updateGuest(newGuest, guest);
        guestRepository.save(newGuest.get());
        return "Guest updated" + newGuest.get().toString();
    }

    private void updateGuest(Optional<Guest> newGuest, Guest guest){
        newGuest.get().setEmail(guest.getEmail());
        newGuest.get().setName(guest.getName());
        newGuest.get().setSocialRegister(guest.getSocialRegister());
        newGuest.get().setPhone(guest.getPhone());
    }
}
