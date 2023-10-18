package com.example.wantedpreonboardingbackend.repository;

import com.example.wantedpreonboardingbackend.entity.Recruitment;
import com.example.wantedpreonboardingbackend.entity.User;
import com.example.wantedpreonboardingbackend.entity.UserRecruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecruitmentRepository extends JpaRepository<UserRecruitment, Long> {
    Boolean existsByUserAndRecruitment(User user, Recruitment recruitment);
}
