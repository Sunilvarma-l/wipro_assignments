package com.example.movie_app_rest_api.service;



import com.example.movie_app_rest_api.model.Theater;
import com.example.movie_app_rest_api.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long id, Theater updated) {
        return theaterRepository.findById(id).map(theater -> {
            theater.setName(updated.getName());
            theater.setLocation(updated.getLocation());
            return theaterRepository.save(theater);
        }).orElse(null);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
