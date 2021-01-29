package com.example.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    boolean isEnabled;

    //public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Column(name = "username", nullable = false)
    public String getUser() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void getPassword(String password) {
        this.password = password;
    }
}
