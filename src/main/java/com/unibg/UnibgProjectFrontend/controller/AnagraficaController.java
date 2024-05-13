package com.unibg.UnibgProjectFrontend.controller;


import com.unibg.UnibgProjectFrontend.entity.UtenteEntity;
import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.AnagraficaService;
import com.unibg.UnibgProjectFrontend.utils.UtilsGeneric;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anagrafica")
public class AnagraficaController {

    @Autowired
    AnagraficaService anagraficaService;

    @GetMapping("/modifica")
    public String modificaAnagrafica(){
        return "login/modificaanagrafica";
    }

    @PostMapping("/modifica/success")
    public String modificaAnagrafica(@ModelAttribute Utente utente, Model model, HttpSession session) {
        if (!UtilsGeneric.isSessionActive(session)) {
            return "error";
        }
        try{
            UtenteEntity utenteEntity = anagraficaService.modificaAnagrafica(utente);
            session.setAttribute("utente", utenteEntity);
            model.addAttribute("utente", utenteEntity);
        } catch(Exception e){
            return "error";
        }

        return "login/modificaanagraficasuccess";
    }

    @PostMapping("/elimina")
    public String eliminaAnagrafica(@ModelAttribute Utente utente, Model model, HttpSession session) {
        if (!UtilsGeneric.isSessionActive(session)) {
            return "error";
        }

        UtenteEntity utenteEntity = (UtenteEntity) session.getAttribute("utente");
        if (anagraficaService.eliminaAnagrafica(utenteEntity)) {
            System.out.println("Utente eliminato con successo");
        } else {
            System.out.println("Errore durante eliminazione dell'utente");
        }

        return "eliminaAnagraficaSuccess";
    }

}
