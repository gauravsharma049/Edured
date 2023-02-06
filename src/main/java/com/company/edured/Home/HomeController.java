package com.company.edured.Home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.edured.user.User;
import com.company.edured.user.Userservice;

@Controller
public class HomeController {
    
    @Autowired
    Userservice us;

    @Autowired
    HomeService homeService;

    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        try{
        String userName = principal.getName();
        System.out.println("USERNAME: " + userName);
        model.addAttribute("loggedinuser", us.getUserbyusername(userName));
        }
        catch(Exception e){
            model.addAttribute("loggedinuser", "anonymous");
            System.out.println("error");
        }
        
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Welcome");
        User user = us.getUserById(1);
        model.addAttribute("role", user.getUsername());
        // model.addAttribute("userobj", new User());
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



    @GetMapping("/dashbord/{username}")
    public String dashbord(@PathVariable("username") String username, Model model){
        model.addAttribute("role", username);
        
        if(us.getUserbyusername(username).getRole().equalsIgnoreCase("role_student")){
            model.addAttribute("title", "Student Dashboard");
            model.addAttribute("userdetail", us.getUserbyusername(username));
            return "studentdashboard";
        }
        else if(us.getUserbyusername(username).getRole().equalsIgnoreCase("role_teacher")){
            model.addAttribute("title", "Teacher Dashboard");
            model.addAttribute("userdetail", us.getUserbyusername(username));
            return "teacher_dashboard";
        }
        else if(us.getUserbyusername(username).getRole().equalsIgnoreCase("role_admin")){
            model.addAttribute("title", "Admin Dashboard");
            model.addAttribute("userdetail", us.getUserbyusername(username));
            return "admin";
        }
        else{
            model.addAttribute("title", "Page not found");
            return "notfound";
        }

    }

    // @GetMapping("/das/{username}")
    // public String das(Model model, @PathVariable("username") String username){
    //     return homeService.displayDashboard(username, model);
    // }
}

