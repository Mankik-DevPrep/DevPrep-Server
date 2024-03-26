package com.example.devprep.comment;

import com.example.devprep.exception.CustomException;
import com.example.devprep.exception.ErrorCode;
import com.example.devprep.member.Member;
import com.example.devprep.member.MemberRepository;
import com.example.devprep.post.Post;
import com.example.devprep.post.PostRepository;
import com.example.devprep.post.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public CommentResponseDto.CommentResponse creatComment(Long postId, Long memberId, CommentRequestDto.CreateCommentRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return CommentConverter.toCommentResponse(commentRepository.save(CommentConverter.toComment(request, member, post)));
    }

    @Override
    @Transactional
    public CommentResponseDto.DeleteCommentResponse deleteComment(Long memberId, Long commentId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        if(comment.getMember().equals(member)) {
            commentRepository.delete(comment);
            return CommentConverter.toDeleteCommentResponse(comment);
        } else {
            throw new CustomException(ErrorCode.FORBIDDEN_COMMENT_USER);
        }
    }

}
