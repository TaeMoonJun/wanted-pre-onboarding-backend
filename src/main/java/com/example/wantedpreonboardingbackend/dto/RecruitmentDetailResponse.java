package com.example.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RecruitmentDetailResponse {
    private Long id;
    private String company;
    private String nation;
    private String region;
    private String position;
    private Integer reward;
    private String tech;
    private String content;
    private List<Long> companyRecruitments;
}
