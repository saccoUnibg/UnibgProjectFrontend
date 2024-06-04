package com.unibg.UnibgProjectFrontend.controller;

import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.AnagraficaService;
import com.unibg.UnibgProjectFrontend.utils.UtilsGeneric;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/anagrafica")
public class AnagraficaController {

    @Autowired
    AnagraficaService anagraficaService;

    @GetMapping("/modifica")
    public String modificaAnagrafica() {
        return "anagrafica/modificaanagrafica";
    }

    @PostMapping("/modifica/success")
    public String modificaAnagrafica(@ModelAttribute Utente utente, Model model, HttpSession session) {
        if (!UtilsGeneric.isSessionActive(session)) {
            return "error";
        }
        try {
            utente = anagraficaService.modificaAnagrafica(utente);
            session.setAttribute("utente", utente);
            model.addAttribute("utente", utente);
        } catch (Exception e) {
            return "error";
        }

        return "anagrafica/modificaanagraficasuccess";
    }

    @PostMapping("/elimina")
    public String eliminaAnagrafica(@ModelAttribute Utente utente, Model model, HttpSession session) {
        if (!UtilsGeneric.isSessionActive(session)) {
            return "error";
        }

        utente = (Utente) session.getAttribute("utente");
        if (anagraficaService.eliminaAnagrafica(utente)) {
            log.info("Utente eliminato con successo");
        } else {
            log.info("Errore durante eliminazione dell'utente");
        }

        return "anagrafica/eliminaAnagraficaSuccess";
    }

}
