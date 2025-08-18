package com.example.classroom_service.repository;


import com.example.classroom_service.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findByInstructor(String instructor);
    List<Classroom> findByScheduledTimeBetween(LocalDateTime start, LocalDateTime end);
}
