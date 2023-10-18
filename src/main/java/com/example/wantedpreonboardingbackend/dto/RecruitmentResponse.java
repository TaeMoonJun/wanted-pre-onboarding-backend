package com.example.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecruitmentResponse {
    private Long id;
    private Long companyId;
    private String position;
    private Integer reward;
    private String content;
    private String tech;
}
