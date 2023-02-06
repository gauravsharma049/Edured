package com.company.edured.user.roles.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
        try{
            
        studentRepository.delete(studentRepository.findById(id).get());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
