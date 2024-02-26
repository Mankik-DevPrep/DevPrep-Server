package com.example.devprep.resume;

import org.springframework.stereotype.Component;

@Component
public class ResumeConverter {
    public ResumeDto.resumeResponseDto createResumeResponse(Resume resume) {
        return ResumeDto.resumeResponseDto.builder()
                .job(resume.getJob())
                .stack(resume.getStack())
                .career(resume.getCareer())
                .project(resume.getProject())
                .note(resume.getNote())
                .build();
    }
}
