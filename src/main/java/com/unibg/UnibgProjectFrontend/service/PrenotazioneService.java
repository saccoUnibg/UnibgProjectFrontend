package com.unibg.UnibgProjectFrontend.service;

import com.unibg.UnibgProjectFrontend.model.Checkin;
import com.unibg.UnibgProjectFrontend.model.Prenotazione;

import java.util.List;

public interface PrenotazioneService {

    Prenotazione savePrenotazione(Prenotazione prenotazione);

    void saveCheckin(List<Checkin> checkin, String mail, String idPrenotazione);

    public List<Prenotazione> getVoliPrenotatiByMail(String mail);

    public void deletePrenotazione(String idPrenotazione);
}
