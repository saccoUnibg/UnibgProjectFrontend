package com.unibg.UnibgProjectFrontend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
public class Ricerca {

    private String partenza;
    private String arrivo;
    private String data;
    private String mail;
    private String durata_min_scalo;
    private String durata_max_scalo;
    private String scalo;
}
