package com.example.devprep.comment;

import lombok.Getter;

public class CommentRequestDto {

    @Getter
    public static class CreateCommentRequest {
        String content;
    }
}
