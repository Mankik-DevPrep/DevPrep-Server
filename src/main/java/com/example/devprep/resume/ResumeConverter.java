package com.example.devprep.resume;

import org.springframework.stereotype.Component;

@Component
public class ResumeConverter {
    public ResumeDto.createResumeResponseDto createResumeResponse(Resume resume) {
        return ResumeDto.createResumeResponseDto.builder()
                .job(resume.getJob())
                .stack(resume.getStack())
                .career(resume.getCareer())
                .project(resume.getProject())
                .note(resume.getNote())
                .build();
    }
}
