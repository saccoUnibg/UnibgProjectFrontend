package com.unibg.UnibgProjectFrontend.controller;


import com.unibg.UnibgProjectFrontend.model.Utente;
import com.unibg.UnibgProjectFrontend.service.LoginService;
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
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("")
    public String homePage(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/registrazione")
    public String registrazione() {
        return "login/registrazione";
    }

    @PostMapping("/registrazioneform")
    public String registrazioneForm(@ModelAttribute("utente") Utente utente, Model model) {
        try {
            utente = loginService.saveRegistrazione(utente);
            return "login/registrazionesuccess";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/profilehomepage")
    public String loginForm(@ModelAttribute("utente") Utente utente, Model model, HttpSession session) {
        try {

            Utente utenteResponse = loginService.login(utente);
            if (utente == null) {
                return "login/login";
            }

            model.addAttribute("utente", utenteResponse);
        } catch (Exception e) {
            model.addAttribute("error", "Errore di login.");
            log.error("Error during login: ", e);
            return "error";
        }
        return "login/profilehomepage";
    }

    @GetMapping("/profilehomepage")
    public String profileHome(Model model, HttpSession session) {
        if (!UtilsGeneric.isSessionActive(session)) {
            return "error";
        }

        Utente utenteEntity = (Utente) session.getAttribute("utente");
        model.addAttribute("utente", utenteEntity);
        return "login/profilehomepage";
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        try {
            session.invalidate();
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex);
        }
        return "login/logout";
    }
}
