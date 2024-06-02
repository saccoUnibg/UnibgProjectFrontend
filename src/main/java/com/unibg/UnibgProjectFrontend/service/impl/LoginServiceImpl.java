package com.unibg.UnibgProjectFrontend.service.impl;

import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${backend.application.ep}")
    private String backendApplicationEp;
    @Value("${login.registrazione}")
    private String registrazioneEp;
    @Value("${login.login}")
    private String loginEp;

    private RestTemplate restTemplate = new RestTemplate();

    public Utente saveRegistrazione(Utente utente) throws Exception {

        String url = backendApplicationEp.concat(registrazioneEp);
        ResponseEntity<Utente> utenteResponse = restTemplate.postForEntity(url, utente, Utente.class);
        if (utenteResponse.getStatusCode().is2xxSuccessful()) {
            return utenteResponse.getBody();
        } else {
            return null;
        }
    }

    public Utente login(Utente utente) {

        String url = backendApplicationEp.concat(loginEp);
        ResponseEntity<Utente> utenteResponse = restTemplate.postForEntity(url, utente, Utente.class);
        if (utenteResponse.getStatusCode().is2xxSuccessful()) {
            return utenteResponse.getBody();
        } else {
            return null;
        }
    }

}
