package com.unibg.UnibgProjectFrontend.utils;

import jakarta.servlet.http.HttpSession;

public class UtilsGeneric {
    public static Boolean isSessionActive( HttpSession session){
        return session.getAttribute("mail") != null;
    }
}
