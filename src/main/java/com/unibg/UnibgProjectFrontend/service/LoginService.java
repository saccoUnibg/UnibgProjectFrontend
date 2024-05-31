package com.unibg.UnibgProjectFrontend.service;

import com.unibg.UnibgProjectFrontend.model.Utente;
import org.springframework.beans.factory.annotation.Value;

public interface LoginService {

    Utente saveRegistrazione(Utente utente) throws Exception;
    Utente login(Utente utente);

}
