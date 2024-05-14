package com.unibg.UnibgProjectFrontend.service;


import com.unibg.UnibgProjectFrontend.model.Utente;

public interface AnagraficaService {
    Utente modificaAnagrafica(Utente utente);

    Boolean eliminaAnagrafica(Utente utente);
}
