package com.example.devprep.post;

import com.example.devprep.post.dto.PostRequestDto;
import com.example.devprep.post.dto.PostResponseDto;

public interface PostService {

    PostResponseDto.CreatePostResponse createPost(PostRequestDto.CreatePostRequest request, Long memberId);

    PostResponseDto.UpdatePostResponse updatePost(PostRequestDto.UpdatePostRequest request, Long memberId);
    Long deletePost(Long postId, Long memberId);

    PostResponseDto.GetPostResponse getPost(Long postId);

}
