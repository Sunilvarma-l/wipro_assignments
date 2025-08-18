package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        Optional<User> usr = userRepository.findById(id);
        return usr.orElse(null);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find users by role
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Count users by role
    public long countUsersByRole(String role) {
        return userRepository.countByRole(role);
    }

    // Find users whose name starts with prefix
    public List<User> getUsersByNameStartsWith(String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    // Find users by name and email
    public User getUserByNameAndEmail(String name, String email) {
        return userRepository.findByNameAndEmail(name, email);
    }
}
