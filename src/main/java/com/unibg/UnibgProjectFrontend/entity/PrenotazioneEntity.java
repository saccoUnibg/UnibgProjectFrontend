package com.unibg.UnibgProjectFrontend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
@Entity(name="prenotazioni")
public class PrenotazioneEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="id_volo")
    private String idVolo;
    @Column
    private String numero_biglietti;
    @Column
    private String mail;
    @Column
    private String spesa_totale;
}
