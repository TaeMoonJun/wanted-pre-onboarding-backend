package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.dto.*;
import com.example.wantedpreonboardingbackend.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {
    private final RecruitmentService recruitmentService;

    @PostMapping("")
    ResponseEntity<RecruitmentResponse> createRecruitment(@RequestBody RegisterRecruitmentRequest recruitmentRequest) {
        return ResponseEntity.ok(recruitmentService.createRecruitment(recruitmentRequest));
    }

    @PutMapping("/{id}")
    ResponseEntity<RecruitmentResponse> updateRecruitment(@PathVariable("id") Long id, @RequestBody UpdateRecruitmentRequest recruitmentRequest){
        return ResponseEntity.ok(recruitmentService.updateRecruitment(id, recruitmentRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteRecruitment(@PathVariable("id") Long id){
        recruitmentService.deleteRecruitment(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @GetMapping("")
    ResponseEntity<List<RecruitmentSummaryResponse>> getRecruitments(){
        return ResponseEntity.ok(recruitmentService.getRecruitments());
    }

    @GetMapping("/{id}")
    ResponseEntity<RecruitmentDetailResponse> getRecruitmentDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(recruitmentService.getRecruitmentDetail(id));
    }

    @PostMapping("/{id}")
    ResponseEntity<String> applyRecruitment(@PathVariable("id") Long recruitmentId, @RequestBody Long userId){
        recruitmentService.applyRecruitment(recruitmentId, userId);
        return ResponseEntity.ok("Successfully Applied");
    }
}
