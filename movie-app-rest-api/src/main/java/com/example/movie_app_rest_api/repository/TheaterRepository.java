package com.example.movie_app_rest_api.repository;


import com.example.movie_app_rest_api.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}

