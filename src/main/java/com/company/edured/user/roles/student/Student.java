package com.company.edured.user.roles.student;

import com.company.edured.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.company.edured.course.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    private int studentId;
    private String about;
    private String skills;
    private String education;
    private String graduationYear;
    private String badges;
    private String worksAt;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Course> courses;

    @OneToOne
    private User user;


}
