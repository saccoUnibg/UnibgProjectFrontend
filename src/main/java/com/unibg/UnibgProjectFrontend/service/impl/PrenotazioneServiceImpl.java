package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.model.Checkin;
import com.unibg.UnibgProjectFrontend.model.Prenotazione;
import com.unibg.UnibgProjectFrontend.service.PrenotazioneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Override
    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        return null;
    }

    @Override
    public void saveCheckin(List<Checkin> checkinList, String mail, String idPrenotazione) {

    }

    public List<Prenotazione> getVoliPrenotatiByMail(String mail) {

        return null;
    }

    @Override
    public void deletePrenotazione(String idPrenotazione) {

    }

    public void deleteCheckin(String idPrenotazione) {

    }

}
