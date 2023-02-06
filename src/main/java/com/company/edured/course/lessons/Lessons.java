package com.company.edured.course.lessons;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.company.edured.course.Course;
import com.company.edured.course.topics.Topics;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

// @Data
@Entity
@Table(name = "lessons")
public class Lessons {
    @Id
    private int id;
    private String lessonsName;

    //every lessons will have multiple topics
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Topics> topics; 
    
    //every lesson will come under a course
    @ManyToOne
    @JsonBackReference
    private Course course;

    public Lessons(int id, String lessonsName, List<Topics> topics, Course course) {
        this.id = id;
        this.lessonsName = lessonsName;
        this.topics = topics;
        this.course = course;
    }

    public Lessons() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonsName() {
        return lessonsName;
    }

    public void setLessonsName(String lessonsName) {
        this.lessonsName = lessonsName;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

 
    
}
