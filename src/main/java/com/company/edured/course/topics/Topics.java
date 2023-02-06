package com.company.edured.course.topics;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.company.edured.course.lessons.Lessons;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Topics {
    @Id
    private int topicId;
    private String topicName;
    private String topicContent;
    private String date;
    private byte rating;

    @ManyToOne
    @JsonBackReference
    private Lessons lesson;

   
}
