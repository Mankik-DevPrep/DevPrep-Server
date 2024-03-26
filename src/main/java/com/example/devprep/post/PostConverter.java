package com.example.devprep.post;

import com.example.devprep.comment.CommentConverter;
import com.example.devprep.member.Member;
import com.example.devprep.post.dto.PostRequestDto;
import com.example.devprep.post.dto.PostResponseDto;

import java.util.stream.Collectors;

public class PostConverter {

    public static PostResponseDto.CreatePostResponse toCreatePostResponse(Post post) {
        return PostResponseDto.CreatePostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .build();
    }

    public static Post toPost(PostRequestDto.CreatePostRequest request, Member member) {
        return Post.builder()
                .title(request.getTitle())
                .category(request.getCategory())
                .content(request.getContent())
                .image(request.getImage())
                .member(member)
                .build();
    }

    public static PostResponseDto.UpdatePostResponse toUpdatePostResponse(Post post) {
        return PostResponseDto.UpdatePostResponse.builder()
                .title(post.getTitle())
                .category(post.getCategory())
                .content(post.getContent())
                .image(post.getImage())
                .build();
    }

    public static PostResponseDto.GetPostResponse toGetPostResponse(Post post) {
        return PostResponseDto.GetPostResponse.builder()
                .title(post.getTitle())
                .category(post.getCategory())
                .content(post.getContent())
                .image(post.getImage())
                .comments(post.getComments().stream().map(comment -> CommentConverter.toCommentResponse(comment))
                        .collect(Collectors.toList()))
                .likeCount(post.getLikes().size())
                .build();
    }
}
