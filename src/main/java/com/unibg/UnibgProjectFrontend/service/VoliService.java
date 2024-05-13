package com.unibg.UnibgProjectFrontend.service;

import com.unibg.UnibgProjectFrontend.model.Prenotazione;
import com.unibg.UnibgProjectFrontend.model.Ricerca;
import com.unibg.UnibgProjectFrontend.model.Volo;

import java.util.List;

public interface VoliService {

     List<Volo> ricercaVoli(Ricerca ricerca);

     List<Volo> getVoliByIdList(List<Long> idList);

     List<Volo> getVoliByPrenotazioni(List<Prenotazione> prenotazioneList);

     Volo getVoloById(Long id);
}
