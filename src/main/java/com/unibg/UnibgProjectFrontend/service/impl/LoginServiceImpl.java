package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${backend.application.ep}")
    private String backendApplicationEp;

    public Utente saveRegistrazione(Utente utente) throws Exception {
//        todo: chiamata rest all'applicazione BE
        
        return null;
    }

    public Utente login(Utente utente){
        return null;
    }

    public Utente findByMail(String mail){
        return null;
    }
}
