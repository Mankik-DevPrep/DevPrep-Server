package com.example.devprep.resume;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;
    private final ResumeConverter resumeConverter;

    @Override
    public ResumeDto.createResumeResponseDto createResume(ResumeDto.createResumeRequestDto request){

        Resume resume = Resume.builder()
                .job(request.getJob())
                .stack(request.getStack())
                .career(request.getCareer())
                .project(request.getProject())
                .note(request.getNote())
                .build();

        resumeRepository.save(resume);

        return resumeConverter.createResumeResponse(resume);
    }

}
