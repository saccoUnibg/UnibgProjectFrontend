package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.model.Checkin;
import com.unibg.UnibgProjectFrontend.model.Prenotazione;
import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Value("${backend.application.ep}")
    private String backendApplicationEp;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        String url = backendApplicationEp.concat("/modifica/success");
        ResponseEntity<Prenotazione> responseEntity = restTemplate.postForEntity(url, prenotazione, Prenotazione.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    @Override
    public void saveCheckin(List<Checkin> checkinList, String mail, String idPrenotazione) {

    }

    public List<Prenotazione> getVoliPrenotatiByMail(String mail) {

        String url = backendApplicationEp.concat("/modifica/success");

        ResponseEntity<List<Prenotazione>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(mail),
                new ParameterizedTypeReference<List<Prenotazione>>() {}
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    @Override
    public void deletePrenotazione(String idPrenotazione) {

    }

    public void deleteCheckin(String idPrenotazione) {

    }

}
