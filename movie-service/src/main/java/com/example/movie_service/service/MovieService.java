package com.example.movie_service.service;

import org.springframework.stereotype.Service;
import com.example.movie_service.repository.MovieRepository;
import com.example.movie_service.model.Movie;
import java.util.List;

@Service
public class MovieService {
  private final MovieRepository repo;
  public MovieService(MovieRepository repo){ this.repo = repo; }

  public List<Movie> findAll(){ return repo.findAll(); }
  public Movie findById(Long id){ return repo.findById(id).orElseThrow(); }
  public Movie save(Movie m){ return repo.save(m); }
  public void delete(Long id){ repo.deleteById(id); }
}
