package com.example.devprep.resume;

import com.example.devprep.exception.CustomException;
import com.example.devprep.exception.ErrorCode;
import com.example.devprep.user.Member;
import com.example.devprep.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;
    private final ResumeConverter resumeConverter;
    private final MemberRepository memberRepository;

    @Override
    public ResumeDto.resumeResponseDto createResume(ResumeDto.resumeRequestDto request){

        Resume resume = Resume.builder()
                .job(request.getJob())
                .stack(request.getStack())
                .career(request.getCareer())
                .project(request.getProject())
                .note(request.getNote())
                .build();

        resumeRepository.save(resume);

        return resumeConverter.resumeResponse(resume);
    }

    @Override
    public ResumeDto.resumeResponseDto updateResume(ResumeDto.resumeRequestDto request, Long id) {
        Optional<Resume> findResume = resumeRepository.findById(id);

        if (findResume.isPresent()){
            Resume resume = findResume.get();
            resume.changeResume(request.getJob(), request.getStack(), request.getCareer(), request.getProject(), request.getNote());
            resumeRepository.save(resume);
            return resumeConverter.resumeResponse(resume);
        } else {
            throw new CustomException(ErrorCode.RESUME_NOT_FOUND);
        }

    }

    @Override
    public Long deleteResume(Long id) {
        Optional<Resume> findResume = resumeRepository.findById(id);

        if (findResume.isPresent()) {
            Resume resume = findResume.get();
            resumeRepository.delete(resume);
            return id;
        } else {
            throw new CustomException(ErrorCode.RESUME_NOT_FOUND);
        }
    }

    @Override
    public ResumeDto.resumeResponseDto getResume(Long id) {
        Optional<Resume> findResume = resumeRepository.findById(id);

        if (findResume.isPresent()) {
            Resume resume = findResume.get();
            return resumeConverter.resumeResponse(resume);
        } else {
            throw new CustomException(ErrorCode.RESUME_NOT_FOUND);
        }
    }

    @Override
    public List<Resume> getResumes(Long memberId) {
        Optional<Member> findmember = memberRepository.findById(memberId);

        if (findmember.isPresent()) {
            List<Resume> resumes = findmember.get().getResumes();
            return resumes;
        } else {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
    }

}
