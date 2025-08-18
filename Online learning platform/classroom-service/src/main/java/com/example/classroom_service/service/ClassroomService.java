package com.example.classroom_service.service;

import com.example.classroom_service.model.Classroom;
import com.example.classroom_service.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }

    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        return classroomRepository.findById(id)
                .map(existing -> {
                    existing.setCourseName(updatedClassroom.getCourseName());
                    existing.setInstructor(updatedClassroom.getInstructor());
                    existing.setScheduledTime(updatedClassroom.getScheduledTime());
                    existing.setDuration(updatedClassroom.getDuration());
                    existing.setStatus(updatedClassroom.getStatus());
                    return classroomRepository.save(existing);
                })
                .orElse(null);
    }
}
