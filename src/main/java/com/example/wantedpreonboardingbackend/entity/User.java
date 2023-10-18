package com.example.wantedpreonboardingbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserRecruitment> appliedRecruitments = new ArrayList<>();

    public void addRecruitment(UserRecruitment recruitment){
        appliedRecruitments.add(recruitment);
    }
}
