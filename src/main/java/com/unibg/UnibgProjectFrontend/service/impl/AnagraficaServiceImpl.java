package com.unibg.UnibgProjectFrontend.service.impl;


import com.unibg.UnibgProjectFrontend.entity.UtenteEntity;
import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.repository.UtenteRepository;
import com.unibg.UnibgProjectFrontend.service.AnagraficaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {
    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public UtenteEntity modificaAnagrafica(Utente utente) {
        try {
            UtenteEntity utenteEntity = utenteRepository.findByMail(utente.getMail());
            BeanUtils.copyProperties(utente, utenteEntity);
            utenteRepository.save(utenteEntity);
            return utenteEntity;
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }

    @Override
    public Boolean eliminaAnagrafica(UtenteEntity utente) {
        try {
            utenteRepository.delete(utente);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
