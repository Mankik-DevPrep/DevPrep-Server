package com.example.devprep.resume;

public interface ResumeService {

    public ResumeDto.resumeResponseDto createResume(ResumeDto.resumeRequestDto createResumeRequestDto);

    public ResumeDto.resumeResponseDto updateResume(ResumeDto.resumeRequestDto updateResumeRequestDto, Long id);
}
