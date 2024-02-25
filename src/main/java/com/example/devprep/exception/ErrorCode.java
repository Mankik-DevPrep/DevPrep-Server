package com.example.devprep.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST: 잘못된 요청


    // 401 UNAUTHORIZED: 인증되지 않은 사용자


    // 403 FORBIDDEN: 접근 권한이 없는 사용자
    FORBIDDEN_POST_USER(FORBIDDEN, "게시글 권한이 없는 사용자입니다."),
    FORBIDDEN_COMMENT_USER(FORBIDDEN, "댓글 권한이 없는 사용자입니다."),
    NOT_IN_POST_COMMENT(FORBIDDEN, "해당 게시글에 속한 댓글이 아닙니다."),

    // 404 NOT_FOUND: 잘못된 리소스 접근
    USER_NOT_FOUND(NOT_FOUND, "해당 회원을 찾을 수 없습니다."),
    RESUME_NOT_FOUND(NOT_FOUND, "해당 이력서를 찾을 수 없습니다."),
    POST_NOT_FOUND(NOT_FOUND, "해당 게시글을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),

    // 409 CONFLICT: 중복된 리소스 (요청이 현재 서버 상태와 충돌될 때)
    DUPLICATE_SOLUTION_BOOKMARK(CONFLICT, "사용자가 이미 북마크한 솔루션입니다."),

    // 500 INTERNAL SERVER ERROR
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "내부 서버 에러입니다."),
    ;


    private final HttpStatus httpStatus;
    private final String message;

}
