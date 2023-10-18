package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.*;

import java.util.List;

public interface RecruitmentService {
    RecruitmentResponse createRecruitment(RegisterRecruitmentRequest registerRecruitmentRequest);

    RecruitmentResponse updateRecruitment(Long recruitmentId, UpdateRecruitmentRequest updateRecruitmentRequest);

    void deleteRecruitment(Long recruitmentId);

    List<RecruitmentSummaryResponse> getRecruitments();

    RecruitmentDetailResponse getRecruitmentDetail(Long recruitmentId);

    void applyRecruitment(Long recruitmentId, Long userId);
}
