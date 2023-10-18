package com.example.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRecruitmentRequest {
    private Long companyId;
    private String position;
    private Integer reward;
    private String content;
    private String tech;
}
