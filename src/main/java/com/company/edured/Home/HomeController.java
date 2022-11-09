package com.company.edured.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Welcome");
        return "index";
    }
    
    @GetMapping("/lessons")
    public String lessons(Model model){
        model.addAttribute("title", "Lessons");
        return "lessons";
    }
    @GetMapping("/contact-us")
    public String contact(Model model){
        model.addAttribute("title", "Contact us");
        return "contact";
    }
    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("title", "edured blog");
        return "blog";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About us");
        return "about";
    }
    @GetMapping("/not-found")
    public String notfound(Model model){
        model.addAttribute("title", "Page not found");
        return "notfound";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Login");
        return "login";
    }
    
    @GetMapping("/dashbord")
    public String dashbord(Model model){
        model.addAttribute("title", "Student Dashbord");
        return "studentdashboard";
    }
}

