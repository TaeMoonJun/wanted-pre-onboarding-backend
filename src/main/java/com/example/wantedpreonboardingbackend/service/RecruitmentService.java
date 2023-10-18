package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.RecruitmentResponse;
import com.example.wantedpreonboardingbackend.dto.RegisterRecruitmentRequest;
import com.example.wantedpreonboardingbackend.dto.RecruitmentSummaryResponse;
import com.example.wantedpreonboardingbackend.dto.UpdateRecruitmentRequest;

import java.util.List;

public interface RecruitmentService {
    RecruitmentResponse createRecruitment(RegisterRecruitmentRequest registerRecruitmentRequest);

    RecruitmentResponse updateRecruitment(Long recruitmentId, UpdateRecruitmentRequest updateRecruitmentRequest);

    void deleteRecruitment(Long recruitmentId);

    List<RecruitmentSummaryResponse> getRecruitments();
}
