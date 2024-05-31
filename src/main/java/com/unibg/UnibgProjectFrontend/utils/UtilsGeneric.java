package com.unibg.UnibgProjectFrontend.utils;

import com.unibg.UnibgProjectFrontend.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UtilsGeneric<T> {

    private RestTemplate restTemplate = new RestTemplate();

    public static Boolean isSessionActive( HttpSession session){
        return session.getAttribute("mail") != null;
    }

}
