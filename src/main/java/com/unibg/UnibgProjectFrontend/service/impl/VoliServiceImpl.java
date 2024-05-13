package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.entity.PrenotazioneEntity;
import com.unibg.UnibgProjectFrontend.entity.VoloEntity;
import com.unibg.UnibgProjectFrontend.model.Prenotazione;
import com.unibg.UnibgProjectFrontend.model.Ricerca;
import com.unibg.UnibgProjectFrontend.model.Volo;
import com.unibg.UnibgProjectFrontend.repository.PrenotazioneRepository;
import com.unibg.UnibgProjectFrontend.repository.VoliRepository;
import com.unibg.UnibgProjectFrontend.service.VoliService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoliServiceImpl implements VoliService {

    @Autowired
    VoliRepository voliRepository;

    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Override
    public List<Volo> ricercaVoli(Ricerca ricerca) {
        List<VoloEntity> voliEntitylist = voliRepository.findByPartenzaAndArrivoIgnoreCaseAndData(ricerca.getPartenza(),ricerca.getArrivo(),ricerca.getData());
        List<Volo> voliList = new ArrayList<>();
        for(VoloEntity tempEntity: voliEntitylist){
           Volo temp = new Volo();
            BeanUtils.copyProperties(tempEntity,temp);
            temp.setId(tempEntity.getId().toString());
            voliList.add(temp);
        }

        // Non voglio mostrare all'utente voli per cui ha gia' effettuato una prenotazione
        // 1. Ottengo la lista di id_volo dalle prenotazioni effettuate da una mail

        List<PrenotazioneEntity> prenotazioneEntityList = prenotazioneRepository.findByMail(ricerca.getMail());
        List<String> idVoliList = new ArrayList<>();
        for(PrenotazioneEntity temp: prenotazioneEntityList){
            idVoliList.add(temp.getIdVolo());
        }

        // 2. Controllo che l'id dei voli delle prenotazioni non sia presente nella lista dei voli generata dalla ricerca;
        //      in caso contrario devo rimuovere tale volo dalla lista di ricerca
        //      Inoltre, la lista dei voli e' gia' ordinata per id; quindi implementare un algoritmo di ricerca che trovi
        //      quelli gia' prenotati

        voliList.removeIf(volo -> idVoliList.contains(volo.getId()));

        return voliList;
    }

    public List<Volo> getVoliByIdList(List<Long> idList){
        List <VoloEntity> voloEntityList= voliRepository.findByIdIn(idList);
        List<Volo> voloList = new ArrayList<>();
        for (VoloEntity tempEntity: voloEntityList) {
            Volo temp = new Volo();
            BeanUtils.copyProperties(tempEntity,temp);
            temp.setId(tempEntity.getId().toString());
            voloList.add(temp);
        }
        return voloList;
    }

    public List<Volo> getVoliByPrenotazioni(List<Prenotazione> listaPrenotazioni) {

        // 1. Ottengo una lista con gli id_volo delle prenotazioni;
        // 2. mi prendo gli oggetti "volo" il cui id è nella lista degli id_volo delle prenotazioni
        List<Long> idVoloList = new ArrayList<>();

        for (Prenotazione temp:listaPrenotazioni) {
            idVoloList.add(Long.valueOf(temp.getIdVolo()));
        }
        List <VoloEntity> voloEntityList= voliRepository.findByIdIn(idVoloList);

        List<Volo> voloList = new ArrayList<>();
        for (VoloEntity tempEntity: voloEntityList) {
            Volo temp = new Volo();
            BeanUtils.copyProperties(tempEntity,temp);
            temp.setId(tempEntity.getId().toString());
            voloList.add(temp);
        }

        return voloList;
    }

    public Volo getVoloById(Long idVolo){
        VoloEntity voloEntity = voliRepository.findById(idVolo);
        Volo volo = new Volo();
        BeanUtils.copyProperties(voloEntity,volo);
        volo.setId(voloEntity.getId().toString());
        return volo;
    }

}
