package com.company.edured.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private User user = new User();
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    Userservice userservice;
    @PostMapping("/signup")
    public String SignUp(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("password") String password){
        user.setName(name);
        user.setUsername(username);
        user.setRole("ROLE_STUDENT");
        user.setPassword(passwordEncoder.encode(password));
        userservice.UserSignUp(user);
        return "redirect:/";
    }

    @PostMapping("/logoutuser")
    public String logout(){
        return "redirect:/logout";
    }
    
}
