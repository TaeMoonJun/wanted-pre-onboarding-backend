package com.example.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecruitmentSummaryResponse {
    private Long id;
    private Long companyId;
    private String position;
    private Integer reward;
    private String tech;
}
