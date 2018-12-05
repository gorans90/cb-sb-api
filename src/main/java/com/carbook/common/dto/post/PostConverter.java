package com.carbook.common.dto.post;

import com.carbook.models.post.Comment;
import com.carbook.models.post.Post;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class PostConverter {

    public static PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(post, postDTO);

        if (post.getComments() != null && !post.getComments().isEmpty()) {
            Set<CommentDTO> commentDTOS = CommentConverter.toDTOSet(post.getComments());
            postDTO.setCommentDTOs(commentDTOS);
        }
        return postDTO;
    }

    public static Post fromDTO(PostDTO postDTO) {
        Post post = new Post();

        ModelMapper mapper = new ModelMapper();
        mapper.map(postDTO, post);

        if (postDTO.getCommentDTOs() != null && !postDTO.getCommentDTOs().isEmpty()) {
            Set<Comment> comments = CommentConverter.fromDTOSet(postDTO.getCommentDTOs());
            post.setComments(comments);
        }

        return post;
    }
}
