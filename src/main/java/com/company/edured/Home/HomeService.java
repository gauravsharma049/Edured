package com.company.edured.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.company.edured.user.Userservice;

@Service
public class HomeService {
    
    @Autowired
    Userservice userservice;

    public String displayDashboard(String username, Model model){
        if(userservice.getUserbyusername(username).getRole().equalsIgnoreCase("role_student")){
            model.addAttribute("title", "Student Dashboard");
            model.addAttribute("userdetail", userservice.getUserbyusername(username));
            return "studentdashboard";
        }
        else if(userservice.getUserbyusername(username).getRole().equalsIgnoreCase("role_teacher")){
            model.addAttribute("title", "Teacher Dashboard");
            model.addAttribute("userdetail", userservice.getUserbyusername(username));
            return "teacher_dashboard";
        }
        else if(userservice.getUserbyusername(username).getRole().equalsIgnoreCase("role_admin")){
            model.addAttribute("title", "Admin Dashboard");
            model.addAttribute("userdetail", userservice.getUserbyusername(username));
            return "admin";
        }
        else{
            model.addAttribute("title", "Page not found");
            return "notfound";
        }

    }
}
