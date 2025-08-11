package com.example.movie_app_rest_api.repository;



import com.example.movie_app_rest_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
