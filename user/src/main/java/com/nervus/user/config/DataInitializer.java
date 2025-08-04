package com.nervus.user.config;

import com.nervus.user.model.User;
import com.nervus.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists to avoid duplication
        if (userRepository.count() == 0) {
            // Seed sample users
            User user1 = new User(1L, "Jane", "Doe", "student");
            User user2 = new User(2L, "John", "Smith", "instructor");
            userRepository.save(user1);
            userRepository.save(user2);
            System.out.println("Seeded 2 users into user service");
        } else {
            System.out.println("Users already seeded, skipping...");
        }
    }
}