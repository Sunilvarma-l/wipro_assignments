package com.example.movie_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.movie_app_rest_api.model.Movie;
import com.example.movie_app_rest_api.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // GET all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // GET movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST create movie
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    // PUT update movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            movie.setTitle(updatedMovie.getTitle());
            movie.setGenre(updatedMovie.getGenre());
            return ResponseEntity.ok(movieService.saveMovie(movie));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE movie
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            movieService.deleteMovie(id);
            return ResponseEntity.ok("Movie deleted with ID " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
