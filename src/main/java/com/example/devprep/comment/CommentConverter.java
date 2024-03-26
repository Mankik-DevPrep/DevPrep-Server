package com.example.devprep.comment;

import com.example.devprep.member.Member;
import com.example.devprep.post.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public static CommentResponseDto.CommentResponse toCommentResponse(Comment comment){
        return CommentResponseDto.CommentResponse.builder()
                .nickName(comment.getMember().getNickname())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static Comment toComment(CommentRequestDto.CreateCommentRequest request, Member member, Post post) {
        return Comment.builder()
                .content(request.getContent())
                .member(member)
                .post(post)
                .build();
    }
    public static CommentResponseDto.DeleteCommentResponse toDeleteCommentResponse(Comment comment) {
        return CommentResponseDto.DeleteCommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .build();
    }

}
