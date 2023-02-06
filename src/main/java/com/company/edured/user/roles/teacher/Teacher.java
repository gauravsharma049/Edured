package com.company.edured.user.roles.teacher;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.company.edured.course.Course;
import com.company.edured.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher {
    @Id
    private int teacherId;
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    private Set<Course> course;
}
