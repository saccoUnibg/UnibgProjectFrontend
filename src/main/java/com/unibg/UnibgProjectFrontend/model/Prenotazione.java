package com.unibg.UnibgProjectFrontend.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Prenotazione {

    private String id;
    private String idVolo;
    private String numero_biglietti;
    private String mail;
    private String spesa_totale;

}
