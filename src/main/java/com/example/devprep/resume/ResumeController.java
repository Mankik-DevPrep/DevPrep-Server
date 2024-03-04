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
    public ResponseEntity<?> createResume(@RequestBody ResumeDto.resumeRequestDto request) {
        return ResponseEntity.ok().body(resumeService.createResume(request));
    }

    @PatchMapping("/rusume/{resumeId}")
    public ResponseEntity<?> updateResume(@RequestBody ResumeDto.resumeRequestDto request, @PathVariable Long resumeId) {
        return ResponseEntity.ok().body(resumeService.updateResume(request, resumeId));
    }

    @DeleteMapping("/resume/{resumeId}")
    public ResponseEntity<?> deleteResume(@PathVariable Long resumeId) {
        return ResponseEntity.ok().body(resumeService.deleteResume(resumeId));
    }

    @GetMapping("/resume/{resumeId}")
    public ResponseEntity<?> getResume(@PathVariable Long resumeId) {
        return ResponseEntity.ok().body(resumeService.getResume(resumeId));
    }

}
