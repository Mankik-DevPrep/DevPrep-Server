package com.example.devprep.resume;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/resume")
    public ResponseEntity<?> createResume(@RequestBody ResumeDto.createResumeRequestDto request) {
        return ResponseEntity.ok().body(resumeService.createResume(request));
    }

}
