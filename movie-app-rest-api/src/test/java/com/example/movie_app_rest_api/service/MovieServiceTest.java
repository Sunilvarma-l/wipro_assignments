package com.example.movie_app_rest_api.service;

import com.example.movie_app_rest_api.model.Movie;
import com.example.movie_app_rest_api.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        movie1 = new Movie();
        movie1.setId(1L);

        movie2 = new Movie();
        movie2.setId(2L);
    }

    @Test
    void testGetAllMovies() {
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        List<Movie> movies = movieService.getAllMovies();

        assertEquals(2, movies.size());
        assertEquals("Salaar", movies.get(0).getTitle());
    }

    @Test
    void testGetMovieByIdExists() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie1));

        Movie result = movieService.getMovieById(1L);

        assertNotNull(result);
        assertEquals("Salaar", result.getTitle());
    }

    @Test
    void testGetMovieByIdNotExists() {
        when(movieRepository.findById(10L)).thenReturn(Optional.empty());

        Movie result = movieService.getMovieById(10L);

        assertNull(result);
    }

    @Test
    void testSaveMovie() {
        when(movieRepository.save(movie1)).thenReturn(movie1);

        Movie result = movieService.saveMovie(movie1);

        assertNotNull(result);
        assertEquals("Salaar", result.getTitle());
        verify(movieRepository, times(1)).save(movie1);
    }

    @Test
    void testDeleteMovie() {
        movieService.deleteMovie(1L);

        verify(movieRepository, times(1)).deleteById(1L);
    }
}
