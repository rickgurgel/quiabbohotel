package com.br.rickgurgel.quiabbohotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String socialRegister;
    private String email;
    private String phone;

    public Guest(String name, String socialRegister, String email, String phone) {
        this.name = name;
        this.socialRegister = socialRegister;
        this.email = email;
        this.phone = phone;
    }
}
