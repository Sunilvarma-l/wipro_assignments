package com.example.movie_app_rest_api.repository;



import com.example.movie_app_rest_api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
