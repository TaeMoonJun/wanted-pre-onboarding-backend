package com.example.wantedpreonboardingbackend.repository;

import com.example.wantedpreonboardingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
