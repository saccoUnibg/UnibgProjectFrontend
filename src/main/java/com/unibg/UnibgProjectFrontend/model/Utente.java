package com.unibg.UnibgProjectFrontend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
public class Utente {

    private String mail;
    private String psw;
    private String nome;
    private String cognome;
    private String cf;
    private String doc_id;

}
