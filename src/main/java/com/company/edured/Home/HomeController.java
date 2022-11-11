package com.company.edured.Home;

import com.company.edured.entity.Student;
import com.company.edured.helper.Message;
import com.company.edured.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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

    // this method for handling student registration

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/do_register")
    public String registration(@ModelAttribute("student")Student student, Model model, HttpSession session){
        try {
            System.out.println("Student: "+ student);

            Student result = this.studentRepository.save(student);
            model.addAttribute("student",result);

            model.addAttribute("student", new Student());
            session.setAttribute("message", new Message("Something went wrong","alert-success"));
            return "index.html";
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("student",student);
            session.setAttribute("message", new Message("Something went wrong","alert-danger"));
            return "index.html";
        }
    }
}

