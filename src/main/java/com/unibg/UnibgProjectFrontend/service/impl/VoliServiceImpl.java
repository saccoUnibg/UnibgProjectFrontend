package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.model.Prenotazione;
import com.unibg.UnibgProjectFrontend.model.Ricerca;
import com.unibg.UnibgProjectFrontend.model.Volo;
import com.unibg.UnibgProjectFrontend.service.VoliService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoliServiceImpl implements VoliService {

    @Override
    public List<Volo> ricercaVoli(Ricerca ricerca) {
        return null;
    }

    public List<Volo> getVoliByIdList(List<Long> idList){
        return null;
    }

    public List<Volo> getVoliByPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        return null;
    }

    public Volo getVoloById(Long idVolo){
        return null;
    }

}
