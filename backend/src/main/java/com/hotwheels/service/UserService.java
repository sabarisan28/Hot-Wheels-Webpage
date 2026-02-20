package com.hotwheels.service;

import com.hotwheels.dto.LoginRequest;
import com.hotwheels.dto.LoginResponse;
import com.hotwheels.dto.UserDTO;
import com.hotwheels.model.User;
import com.hotwheels.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    /**
     * Register a new user with encrypted password
     */
    public UserDTO registerUser(UserDTO userDTO) {
        log.info("Attempting to register user with email: {}", userDTO.getEmail());
        
        // Check if user already exists (case-insensitive)
        if (userRepository.existsByEmailIgnoreCase(userDTO.getEmail())) {
            log.error("Registration failed: Email already exists - {}", userDTO.getEmail());
            throw new RuntimeException("Email already registered");
        }
        
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail().toLowerCase().trim()); // Normalize email
        
        // Encode password using BCrypt
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        log.info("Password encoded successfully for user: {}", userDTO.getEmail());
        
        user.setRole(userDTO.getRole() != null ? userDTO.getRole() : "USER");
        
        User savedUser = userRepository.save(user);
        log.info("User registered successfully with ID: {}", savedUser.getId());
        
        return convertToDTO(savedUser);
    }
    
    /**
     * Login user with email and password validation
     */
    public LoginResponse loginUser(LoginRequest loginRequest) {
        String email = loginRequest.getEmail().toLowerCase().trim();
        String rawPassword = loginRequest.getPassword();
        
        log.info("Login attempt for email: {}", email);
        
        // Find user by email (case-insensitive)
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> {
                    log.error("Login failed: User not found with email - {}", email);
                    return new RuntimeException("Invalid email or password");
                });
        
        log.info("User found in database: ID={}, Email={}", user.getId(), user.getEmail());
        
        // Validate password using BCrypt
        boolean passwordMatches = passwordEncoder.matches(rawPassword, user.getPassword());
        log.info("Password validation result: {}", passwordMatches);
        
        if (!passwordMatches) {
            log.error("Login failed: Invalid password for email - {}", email);
            throw new RuntimeException("Invalid email or password");
        }
        
        log.info("Login successful for user: {}", email);
        
        return new LoginResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole()
        );
    }
    
    /**
     * Get all users (for admin purposes)
     */
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Convert User entity to UserDTO (without password)
     */
    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        // Never return password in DTO
        return dto;
    }
}
