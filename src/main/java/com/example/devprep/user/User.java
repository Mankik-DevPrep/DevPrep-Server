package com.example.devprep.user;

import com.example.devprep.resume.ResumeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String password;

    private String nickname;

    // 추후 수정 예정
    private String image;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserEnum.Level level;

}
