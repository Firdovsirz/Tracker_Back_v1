package com.tracker.demo.controllers;


import com.tracker.demo.DTO.ApiResponse;
import com.tracker.demo.DTO.UserDTO;
import com.tracker.demo.entity.User;
import com.tracker.demo.exception.CustomException;
import com.tracker.demo.services.UserService;
import com.tracker.demo.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "https://trackerfrontv1-production.up.railway.app/")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<?>> signup(@RequestBody User user) {
        try {
            userService.save(user); // Save worker but don't return the object
            return ResponseEntity.ok(ApiResponse.success("Worker registered successfully"));
        } catch (CustomException e) { // Handle known exceptions
            return ResponseEntity
                    .status(e.getStatus())
                    .body(ApiResponse.error(e.getStatus(), e.getErrorCode(), e.getMessage()));
        } catch (Exception e) { // Handle unknown errors
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "INTERNAL_ERROR", "Something went wrong"));
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<?>> signin(@RequestBody User user) {
        try {
            Optional<User> existingWorker = userService.authenticate(user.getUsername(), user.getPasswordHash());
            if (existingWorker.isPresent()) {
                User authenticatedUser = existingWorker.get();
                UserDTO userDTO = new UserDTO(
                        authenticatedUser.getId(),
                        authenticatedUser.getName(),
                        authenticatedUser.getLastname(),
                        authenticatedUser.getUsername(),
                        authenticatedUser.getCreatedAt(),
                        authenticatedUser.getEmail(),
                        authenticatedUser.getRole());
                String token = JwtUtil.generateToken(authenticatedUser.getUsername(), authenticatedUser.getRole());

                return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(new SignInResponse(userDTO, token)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error(401, "INVALID_CREDENTIALS", "Invalid email or password"));
            }
        } catch (Exception e) { // Generic exception handling
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "INTERNAL_ERROR", "Something went wrong"));
        }
    }

    public static class SignInResponse {
        private UserDTO userDTO;
        private String token;

        public SignInResponse(UserDTO userDTO, String token) {
            this.userDTO = userDTO;
            this.token = token;
        }

        public UserDTO getUserDTO() {
            return userDTO;
        }

        public void setUserDTO(UserDTO userDTO) {
            this.userDTO = userDTO;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
