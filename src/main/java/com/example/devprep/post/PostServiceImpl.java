package com.example.devprep.post;

import com.example.devprep.exception.CustomException;
import com.example.devprep.exception.ErrorCode;
import com.example.devprep.member.Member;
import com.example.devprep.member.MemberRepository;
import com.example.devprep.post.dto.PostRequestDto;
import com.example.devprep.post.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;


    @Override
    @Transactional
    public PostResponseDto.CreatePostResponse createPost(PostRequestDto.CreatePostRequest request, Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Post post = postRepository.save(PostConverter.toPost(request, member));

        return PostConverter.toCreatePostResponse(post);
    }

    @Override
    @Transactional
    public PostResponseDto.UpdatePostResponse updatePost(PostRequestDto.UpdatePostRequest request, Long memberId) {

        Post post = postRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        if(post.getMember().getId().equals(memberId)) {
            post.setTitle(request.getTitle());
            post.setCategory(request.getCategory());
            post.setContent(request.getContent());
            post.setImage(request.getImage());
        } else {
            throw new CustomException(ErrorCode.FORBIDDEN_POST_USER);
        }

        return PostConverter.toUpdatePostResponse(post);
    }

    @Override
    @Transactional
    public Long deletePost(Long postId, Long memberId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        if(post.getMember().getId().equals(memberId)) {
            postRepository.delete(post);
            return post.getId();
        } else {
            throw new CustomException(ErrorCode.FORBIDDEN_POST_USER);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto.GetPostResponse getPost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        return PostConverter.toGetPostResponse(post);
    }
}
