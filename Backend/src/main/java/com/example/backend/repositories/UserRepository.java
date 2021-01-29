package com.example.backend.repositories;


import com.example.backend.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
