package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {

    @Value("${backend.application.ep}")
    private String backendApplicationEp;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Utente modificaAnagrafica(Utente utente) {
        String url = backendApplicationEp.concat("/modifica/success");
        ResponseEntity<Utente> utenteResponse = restTemplate.postForEntity(url, utente, Utente.class);
        if (utenteResponse.getStatusCode().is2xxSuccessful()) {
            return utenteResponse.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Boolean eliminaAnagrafica(Utente utente) {
        String url = backendApplicationEp.concat("/elimina");
        ResponseEntity<Boolean> utenteResponse = restTemplate.postForEntity(url, utente, Boolean.class);
        if (utenteResponse.getStatusCode().is2xxSuccessful()) {
            return utenteResponse.getBody();
        } else {
            return null;
        }
    }
}
