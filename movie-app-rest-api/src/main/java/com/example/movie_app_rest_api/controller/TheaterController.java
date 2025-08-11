package com.example.movie_app_rest_api.controller;

import com.example.movie_app_rest_api.model.Theater;
import com.example.movie_app_rest_api.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("/{id}")
    public Theater getTheaterById(@PathVariable Long id) {
        return theaterService.getTheaterById(id).orElse(null);
    }

    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.createTheater(theater);
    }

    @PutMapping("/{id}")
    public Theater updateTheater(@PathVariable Long id, @RequestBody Theater updatedTheater) {
        return theaterService.updateTheater(id, updatedTheater);
    }

    @DeleteMapping("/{id}")
    public void deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
    }
}
