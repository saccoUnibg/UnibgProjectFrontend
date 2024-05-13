package com.unibg.UnibgProjectFrontend.service;


import com.unibg.UnibgProjectFrontend.entity.UtenteEntity;
import com.unibg.UnibgProjectFrontend.model.Utente;

public interface AnagraficaService {
    UtenteEntity modificaAnagrafica(Utente utente);

    Boolean eliminaAnagrafica(UtenteEntity utente);
}
