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
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "position")
    private String position;

    @Column(name = "reward")
    private Integer reward;

    @Column(name = "content")
    private String content;

    @Column(name = "tech")
    private String tech;

    @OneToMany(mappedBy = "recruitment", cascade = CascadeType.REMOVE)
    private List<UserRecruitment> appliedUsers = new ArrayList<>();

    public void addUser(UserRecruitment user){
        appliedUsers.add(user);
    }

    public void update(String position, Integer reward, String content, String tech){
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }
}
