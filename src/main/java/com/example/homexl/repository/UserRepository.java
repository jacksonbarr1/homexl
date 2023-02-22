package com.example.homexl.repository;

import com.example.homexl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    Optional<UserDetails> findByUsername(String username);
}
