package com.example.devprep.post.dto;

import com.example.devprep.comment.Comment;
import com.example.devprep.comment.CommentResponseDto;
import com.example.devprep.post.PostEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatePostResponse {
        Long id;
        String title;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdatePostResponse {
        String title;
        PostEnum.PostCategory category;
        String content;
        String image;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetPostResponse {
        String title;
        PostEnum.PostCategory category;
        String content;
        String image;
        List<CommentResponseDto.CommentResponse> comments;
        Integer likeCount;
    }

}
