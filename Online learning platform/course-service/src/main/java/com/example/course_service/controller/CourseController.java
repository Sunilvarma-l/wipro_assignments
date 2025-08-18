package com.example.course_service.controller;


import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/instructor/{instructor}")
    public List<Course> getCoursesByInstructor(@PathVariable String instructor) {
        return courseService.getCoursesByInstructor(instructor);
    }

    @GetMapping("/search")
    public List<Course> searchCoursesByTitle(@RequestParam String keyword) {
        return courseService.searchCoursesByTitle(keyword);
    }
}
