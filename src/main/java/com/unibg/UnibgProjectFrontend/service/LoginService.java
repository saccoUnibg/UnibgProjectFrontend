package com.unibg.UnibgProjectFrontend.service;


import com.unibg.UnibgProjectFrontend.entity.UtenteEntity;
import com.unibg.UnibgProjectFrontend.model.Utente;

public interface LoginService {

    UtenteEntity saveRegistrazione(Utente utente) throws Exception;

    UtenteEntity login(Utente utente);

    UtenteEntity findByMail(String mail);
}
