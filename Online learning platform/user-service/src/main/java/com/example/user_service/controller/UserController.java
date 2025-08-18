package com.example.user_service.controller;


import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    @GetMapping("/count/role/{role}")
    public long countUsersByRole(@PathVariable String role) {
        return userService.countUsersByRole(role);
    }

    @GetMapping("/name/prefix/{prefix}")
    public List<User> getUsersByNameStartsWith(@PathVariable String prefix) {
        return userService.getUsersByNameStartsWith(prefix);
    }

    @GetMapping("/search")
    public User getUserByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return userService.getUserByNameAndEmail(name, email);
        
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setRole(userDetails.getRole());
            return userService.saveUser(existingUser);
        }
        return null; // Or throw an exception
    }
}
