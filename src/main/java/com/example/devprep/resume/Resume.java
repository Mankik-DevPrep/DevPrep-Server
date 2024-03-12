package com.example.devprep.resume;

import com.example.devprep.user.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResumeEnum.Job job;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResumeEnum.Stack stack;

    private Boolean career;

    private String project;

    private String note;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void changeResume(ResumeEnum.Job newJob, ResumeEnum.Stack newStack, Boolean newCareer, String newProject, String newNote) {
        this.job = newJob;
        this.stack = newStack;
        this.career = newCareer;
        this.project = newProject;
        this.note = newNote;
    }

}
