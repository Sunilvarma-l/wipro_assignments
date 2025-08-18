package com.example.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_service.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(String instructor);
    List<Course> findByTitleContaining(String keyword);
}
