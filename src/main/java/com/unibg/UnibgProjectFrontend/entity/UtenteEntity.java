package com.unibg.UnibgProjectFrontend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name = "utenti")
@Getter
@Setter
public class UtenteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String mail;
    @Column
    private String psw;
    @Column
    private String cf;

}
