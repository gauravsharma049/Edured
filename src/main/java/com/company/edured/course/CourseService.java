package com.company.edured.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    public Course addCourse(Course course){
       return courseRepository.save(course);
    }

    public void deleteCourse(int id){
        courseRepository.delete(courseRepository.findById(id).get());
    }

    public List<Course> getAllCourse(){
        List<Course> lst = courseRepository.findAll();
        for (Course course : lst) {
            System.out.println(course);
        }
        return lst;
    }
}
