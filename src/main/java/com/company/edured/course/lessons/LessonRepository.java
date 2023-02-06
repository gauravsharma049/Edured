package com.company.edured.course.lessons;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lessons, Integer>{
    
}
