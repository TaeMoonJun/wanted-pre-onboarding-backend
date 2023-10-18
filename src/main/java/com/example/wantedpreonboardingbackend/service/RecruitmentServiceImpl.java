package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.dto.*;
import com.example.wantedpreonboardingbackend.entity.Company;
import com.example.wantedpreonboardingbackend.entity.Recruitment;
import com.example.wantedpreonboardingbackend.entity.User;
import com.example.wantedpreonboardingbackend.entity.UserRecruitment;
import com.example.wantedpreonboardingbackend.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.repository.RecruitmentRepository;
import com.example.wantedpreonboardingbackend.repository.UserRecruitmentRepository;
import com.example.wantedpreonboardingbackend.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final UserRecruitmentRepository userRecruitmentRepository;

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

    @Override
    public RecruitmentDetailResponse getRecruitmentDetail(Long recruitmentId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).get();
        Company company = companyRepository.findById(recruitment.getCompany().getId()).get();
        List<Long> companyRecruitments = recruitmentRepository.findAllByCompanyId(company.getId())
                .stream().map(Recruitment::getId)
                .collect(Collectors.toList());

        return RecruitmentDetailResponse.builder()
                .id(recruitment.getId())
                .company(company.getName())
                .nation(company.getNation())
                .region(company.getRegion())
                .position(recruitment.getPosition())
                .reward(recruitment.getReward())
                .tech(recruitment.getTech())
                .content(recruitment.getContent())
                .companyRecruitments(companyRecruitments)
                .build();
    }

    @Override
    public void applyRecruitment(Long recruitmentId, Long userId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId).get();
        User user = userRepository.findById(userId).get();

        if(!userRecruitmentRepository.existsByUserAndRecruitment(user, recruitment)){
            UserRecruitment applied = UserRecruitment.builder()
                    .user(user)
                    .recruitment(recruitment)
                    .build();
            userRecruitmentRepository.save(applied);
        }
    }
}
