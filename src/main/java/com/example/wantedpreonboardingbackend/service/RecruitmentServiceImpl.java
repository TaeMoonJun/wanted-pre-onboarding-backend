package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.RecruitmentResponse;
import com.example.wantedpreonboardingbackend.dto.RegisterRecruitmentRequest;
import com.example.wantedpreonboardingbackend.dto.RecruitmentSummaryResponse;
import com.example.wantedpreonboardingbackend.dto.UpdateRecruitmentRequest;
import com.example.wantedpreonboardingbackend.entity.Company;
import com.example.wantedpreonboardingbackend.entity.Recruitment;
import com.example.wantedpreonboardingbackend.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RecruitmentServiceImpl implements RecruitmentService {
    private final RecruitmentRepository recruitmentRepository;
    private final CompanyRepository companyRepository;

    @Override
    public RecruitmentResponse createRecruitment(RegisterRecruitmentRequest registerRecruitmentRequest) {
        Company company = companyRepository.findById(registerRecruitmentRequest.getCompanyId()).get();
        Recruitment recruitment = Recruitment.builder()
                .company(company)
                .position(registerRecruitmentRequest.getPosition())
                .reward(registerRecruitmentRequest.getReward())
                .content(registerRecruitmentRequest.getContent())
                .tech(registerRecruitmentRequest.getTech())
                .build();
        recruitmentRepository.save(recruitment);

        return RecruitmentResponse.builder()
                .companyId(company.getId())
                .position(recruitment.getPosition())
                .reward(recruitment.getReward())
                .content(recruitment.getContent())
                .tech(recruitment.getTech())
                .build();
    }

    @Override
    public RecruitmentResponse updateRecruitment(Long recruitmentId, UpdateRecruitmentRequest updateRecruitmentRequest) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).get();
        recruitment.update(updateRecruitmentRequest.getPosition(), updateRecruitmentRequest.getReward(),
                updateRecruitmentRequest.getContent(), updateRecruitmentRequest.getTech());
//        recruitmentRepository.save(recruitment);

        return RecruitmentResponse.builder()
                .companyId(recruitment.getCompany().getId())
                .position(recruitment.getPosition())
                .reward(recruitment.getReward())
                .content(recruitment.getContent())
                .tech(recruitment.getTech())
                .build();
    }

    @Override
    public void deleteRecruitment(Long recruitmentId) {
        recruitmentRepository.deleteById(recruitmentId);
    }

    @Override
    public List<RecruitmentSummaryResponse> getRecruitments() {
        return recruitmentRepository.findAll()
                .stream().map(recruitment -> new RecruitmentSummaryResponse(recruitment.getId(),
                        recruitment.getCompany().getId(), recruitment.getPosition(),
                        recruitment.getReward(), recruitment.getTech()))
                .collect(Collectors.toList());
    }
}