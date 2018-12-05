package com.carbook.common.dto.post;

import com.carbook.models.post.Comment;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommentConverter {

    public static CommentDTO toDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(comment, commentDTO);

        return commentDTO;
    }

    public static Comment fromDTO(CommentDTO commentDTO) {
        Comment comment = new Comment();

        ModelMapper mapper = new ModelMapper();
        mapper.map(commentDTO, comment);

        return comment;
    }

    public static Set<CommentDTO> toDTOSet(Set<Comment> comments) {
        return comments.stream().map(CommentConverter::toDTO).collect(Collectors.toSet());
    }

    public static Set<Comment> fromDTOSet(Set<CommentDTO> commentDTOS) {
        return commentDTOS.stream().map(CommentConverter::fromDTO).collect(Collectors.toSet());
    }
}
