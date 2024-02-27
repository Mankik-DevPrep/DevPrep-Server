package com.example.devprep.resume;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/create")
    public ResponseEntity<?> createResume(@RequestBody ResumeDto.resumeRequestDto request) {
        return ResponseEntity.ok().body(resumeService.createResume(request));
    }

    @PatchMapping("/update/{resumeId}")
    public ResponseEntity<?> updateResume(@RequestBody ResumeDto.resumeRequestDto request, @PathVariable Long Id) {
        return ResponseEntity.ok().body(resumeService.updateResume(request, Id));
    }

}
