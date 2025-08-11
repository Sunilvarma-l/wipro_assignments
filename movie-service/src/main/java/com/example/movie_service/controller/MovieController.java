package com.example.movie_service.controller;
import org.springframework.web.bind.annotation.*;
import com.example.movie_service.service.MovieService;
import com.example.movie_service.model.Movie;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
  private final MovieService movieService;
  public MovieController(MovieService movieService){ this.movieService = movieService; }

  @GetMapping
  public List<Movie> all(){ return movieService.findAll(); }

  @GetMapping("/{id}")
  public Movie one(@PathVariable Long id){ return movieService.findById(id); }

  @PostMapping
  public Movie create(@RequestBody Movie movie){ return movieService.save(movie); }

  @PutMapping("/{id}")
  public Movie update(@PathVariable Long id, @RequestBody Movie movie){
    Movie existing = movieService.findById(id);
    existing.setTitle(movie.getTitle());
    existing.setGenre(movie.getGenre());
    return movieService.save(existing);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){ movieService.delete(id); }
}
