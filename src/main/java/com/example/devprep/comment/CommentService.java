package com.example.devprep.comment;

public interface CommentService {

    CommentResponseDto.CommentResponse creatComment(Long postId, Long memberId, CommentRequestDto.CreateCommentRequest request);

    CommentResponseDto.DeleteCommentResponse deleteComment(Long memberId, Long commentId);
}
