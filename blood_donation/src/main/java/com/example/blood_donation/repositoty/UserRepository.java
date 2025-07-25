package com.example.blood_donation.repositoty;

import com.example.blood_donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserID(Long userID);
    Optional<User> findByPhone(String phone);

    Optional<User> findByUsername(String adminUsername);

    Optional<User> findByEmail(String email);

    boolean existsByUsernameAndUserIDNot(String username, Long id);

    boolean existsByEmailAndUserIDNot(String email, Long id);

    boolean existsByCccdAndUserIDNot(String cccd, Long id);
}
