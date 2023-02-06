package com.company.edured.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
    @Autowired
    CourseService courseService;

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return "deleted";
    }

    @PostMapping("/add")
    public Course add(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/get")
    public List<Course> get(){
        return courseService.getAllCourse();
    }
}
