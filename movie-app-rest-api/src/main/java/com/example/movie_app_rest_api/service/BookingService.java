package com.example.movie_app_rest_api.service;


import com.example.movie_app_rest_api.model.Booking;
import com.example.movie_app_rest_api.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updated) {
        return bookingRepository.findById(id).map(b -> {
            b.setBookingDate(updated.getBookingDate());
            b.setSeats(updated.getSeats());
            b.setMovie(updated.getMovie());
            b.setTheater(updated.getTheater());
            b.setCustomer(updated.getCustomer());
            return bookingRepository.save(b);
        }).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

