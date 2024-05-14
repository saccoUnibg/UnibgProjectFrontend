package com.unibg.UnibgProjectFrontend.controller;

import com.unibg.UnibgProjectFrontend.model.*;
import com.unibg.UnibgProjectFrontend.service.LoginService;
import com.unibg.UnibgProjectFrontend.service.PrenotazioneService;
import com.unibg.UnibgProjectFrontend.service.VoliService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    LoginService loginService;

    @Autowired
    VoliService voliService;

    @PostMapping("/crea")
    public String creaPrenotazione(@ModelAttribute("volo") Volo volo, HttpSession session, Model model) {
        session.setAttribute("id_volo",volo.getId());
        return "prenotazione/creaprenotazione";
    }

    @PostMapping("/check-in")
    public String checkIn(@ModelAttribute("prenotazione") Prenotazione prenotazione, HttpSession session, Model model) {
        try{
            //Imposto id_volo nella prenotazione (preso da session) e la salvo
            prenotazione.setIdVolo((String)session.getAttribute("id_volo"));
            prenotazione.setMail((String) session.getAttribute("mail"));
            prenotazione = prenotazioneService.savePrenotazione(prenotazione);

            //salvo in sessione id_prenotazione
            session.setAttribute("id_prenotazione",prenotazione.getId());

            //Creo lista di checkin per popolare il form nel modo corretto
            List<Checkin> tempList = new ArrayList<>();
            for(int i = 0;i<Integer.parseInt(prenotazione.getNumero_biglietti());i++){
                tempList.add(new Checkin());
            }
            CheckinList checkinList = new CheckinList();
            checkinList.setCheckins(tempList);
            //aggiungo la lista al model da restituire al fe
            model.addAttribute("checkinList",checkinList);
        } catch(Exception e){
            return "error";
        }
        return "prenotazione/checkin";
    }

    @PostMapping("/success")
    public String saveCheckin(@ModelAttribute("checkinList") CheckinList checkinList, HttpSession session, Model model) {
        try{
            String mail=(String) session.getAttribute("mail");
            String idPrenotazione = (String) session.getAttribute("id_prenotazione");
            prenotazioneService.saveCheckin(checkinList.getCheckins(),mail,idPrenotazione);
            Utente utente = loginService.findByMail(mail);
            model.addAttribute(utente);
        } catch(Exception e){
            return "error";
        }
        return "login/profilehomepage";
    }

    @GetMapping("/visualizza")
    public String visualizzaPrenotazioni(HttpSession session, Model model){

        //Ottengo lista delle prenotazioni effettuate da una utenza via mail
        List<Prenotazione> prenotazioneList =
                prenotazioneService.getVoliPrenotatiByMail((String)session.getAttribute("mail"));

        // Ottengo i dettagli dei voli delle prenotazioni effettuate
        List<Volo> listaVoli =
                voliService.getVoliByPrenotazioni(prenotazioneList);

        // Mappa con associazione id volo e id prenotazione per non doverlo recuperare dopo da db con altre queries
        Map<String,String> idPrenotazioniAndVoli = new HashMap<>();
        for(Prenotazione temp: prenotazioneList){
            idPrenotazioniAndVoli.put(temp.getIdVolo(),temp.getId());
        }
        session.setAttribute("idPrenotazioniAndVoli",idPrenotazioniAndVoli);

        model.addAttribute("listaVoli",listaVoli);

        return "prenotazione/visualizzaprenotazioni";
    }

    @PostMapping("/elimina")
    public String eliminaPrenotazione(@ModelAttribute("volo") Volo volo, HttpSession session, Model model){

        // una volta confermato, cancello tutto ciò che è legato alla mail per quel id_volo (prenotazione + checkIn di ogni persona)
        String idVolo = volo.getId();
        session.setAttribute("id_volo",idVolo);

        model.addAttribute("volo",volo);
        return "prenotazione/eliminaprenotazione";
    }

    @PostMapping("/elimina/conferma")
    public String confermaEliminaPrenotazione(HttpSession session,Model model){
        try{
            // 1. recupero informazioni dalla sessione
            String idVolo = (String) session.getAttribute("id_volo");

            // chiave: idPrenotazione ; valore: idVolo
            Map<String,String> idPrenotazioniAndVoli = (HashMap<String,String>) session.getAttribute("idPrenotazioniAndVoli");

            // 2. recupero idPrenotazione dalla map con idVolo ( non filtro per mail, perchè la mappa e' gia' filtrata per mail utenza)
            String idPrenotazione = idPrenotazioniAndVoli.get(idVolo);
            prenotazioneService.deletePrenotazione(idPrenotazione);

        } catch (Exception e){
            return "error";
        }

        return "prenotazione/confermaeliminaprenotazione";
    }
}
