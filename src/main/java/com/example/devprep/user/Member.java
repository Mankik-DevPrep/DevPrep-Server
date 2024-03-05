package com.example.devprep.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

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
    private MemberEnum.Level level;

}
