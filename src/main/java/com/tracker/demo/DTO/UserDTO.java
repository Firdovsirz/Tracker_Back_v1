package com.tracker.demo.DTO;

import java.util.Date;
import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private Date createdAt;
    private String email;
    private String role;

    public UserDTO(Long id, String name, String lastname, String username, Date createdAt, String email, List<String> role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.createdAt = createdAt;
        this.email = email;
        this.role = String.valueOf(role);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
