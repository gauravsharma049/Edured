package com.company.edured.course;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.company.edured.course.lessons.*;
import com.company.edured.user.roles.student.Student;
import com.company.edured.user.roles.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Course {
    @Id
    private int id;
    private String courseName;
    private String dateOfCreation;
    private String lastUpdatedDate;
    private int rating;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lessons> lessons;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private List<Student> students;

    @ManyToOne
    @JsonManagedReference
    private Teacher teacher;

    public Course(int id, String courseName, String dateOfCreation, String lastUpdatedDate, int rating,
            List<Lessons> lessons, List<Student> students, Teacher teacher) {
        this.id = id;
        this.courseName = courseName;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdatedDate = lastUpdatedDate;
        this.rating = rating;
        this.lessons = lessons;
        this.students = students;
        this.teacher = teacher;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

   

    
}
