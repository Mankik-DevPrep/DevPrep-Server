package com.example.devprep.resume;

import java.util.List;

public interface ResumeService {

    ResumeDto.resumeResponseDto createResume(ResumeDto.resumeRequestDto createResumeRequestDto);

    ResumeDto.resumeResponseDto updateResume(ResumeDto.resumeRequestDto updateResumeRequestDto, Long id);

    Long deleteResume(Long id);

    ResumeDto.resumeResponseDto getResume(Long id);

    List<Resume> getResumes(Long memberId);

}
