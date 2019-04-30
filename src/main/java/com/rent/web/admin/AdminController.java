package com.rent.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/index")
    public String index(HttpSession session) {

        if (session.getAttribute("admin") != null) {
            return "admin/index";
        } else {
            return "redirect:/login.html";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/login.html";
    }

}
