package com.example.devprep.post.dto;

import com.example.devprep.post.PostEnum;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class PostRequestDto {

    @Getter
    public static class CreatePostRequest {
        String title;
        PostEnum.PostCategory category;
        String content;
        String image;
    }

    @Getter
    public static class UpdatePostRequest {
        Long id;
        String title;
        PostEnum.PostCategory category;
        String content;
        String image;
    }
}
