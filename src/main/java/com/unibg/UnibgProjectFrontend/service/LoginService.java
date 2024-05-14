package com.unibg.UnibgProjectFrontend.service;

import com.unibg.UnibgProjectFrontend.model.Utente;

public interface LoginService {

    Utente saveRegistrazione(Utente utente) throws Exception;

    Utente login(Utente utente);

    Utente findByMail(String mail);
}
