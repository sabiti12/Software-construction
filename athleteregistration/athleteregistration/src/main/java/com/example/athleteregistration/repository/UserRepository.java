package com.example.athleteregistration.repository;

import com.example.athleteregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);
    
    Optional<User> findBySport(String sport);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    Boolean existsBySport(String sport);
}