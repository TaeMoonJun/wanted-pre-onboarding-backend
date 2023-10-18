//package com.example.wantedpreonboardingbackend.controller;
//
//import com.example.wantedpreonboardingbackend.dto.RegisterRecruitmentRequest;
//import com.example.wantedpreonboardingbackend.entity.Recruitment;
//import com.example.wantedpreonboardingbackend.service.RecruitmentService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.annotation.Before;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest
//@ExtendWith(MockitoExtension.class)
//class RecruitmentControllerTest {
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @InjectMocks
//    private RecruitmentController recruitmentController;
//
//    @Mock
//    RecruitmentService recruitmentService;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void init() {
//        mockMvc = MockMvcBuilders.standaloneSetup(recruitmentController).build();
//    }
//
//    @Test
//    void postRecruitmentTest() throws Exception {
//        RegisterRecruitmentRequest request = registerRecruitmentRequest();
//
//        Mockito.doReturn(new Recruitment()).when(recruitmentService)
//                .createRecruitment(ArgumentMatchers.any(RegisterRecruitmentRequest.class));
//
//        ResultActions actions = mockMvc.perform(
//                MockMvcRequestBuilders.post("/user/signUp")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        );
//
//        MvcResult mvcResult = actions.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        String token = mvcResult.getResponse().getContentAsString();
//        Assertions.assertThat(token).isNotNull();
//    }
//
//    private RegisterRecruitmentRequest registerRecruitmentRequest() {
//        RegisterRecruitmentRequest request = RegisterRecruitmentRequest.builder()
//                .companyId(1L)
//                .tech("java")
//                .reward(10000)
//                .position("backend")
//                .content("welcome")
//                .build();
//        return request;
//    }
//
//}