package com.example.user_service.repository;
import com.example.user_service.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByRole(String role);

    long countByRole(String role);

    List<User> findByNameStartingWith(String prefix);

    User findByNameAndEmail(String name, String email);

    // Example: custom query to get users by email domain
    @Query("SELECT u FROM User u WHERE u.email LIKE %?1")
    List<User> findUsersByEmailDomain(String domain);
}
