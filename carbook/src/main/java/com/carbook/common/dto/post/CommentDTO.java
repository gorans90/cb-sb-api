package com.carbook.common.dto.post;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.models.user.User;

import java.util.Date;

public class CommentDTO {
    private Integer id;
    private Date dateCreated;
    private User createdBy;
    private String content;
    private PostDTO postDTO;
    private ErrorDTO errorDTO;

    public CommentDTO(Integer id, Date dateCreated, User createdBy, String content, PostDTO postDTO, ErrorDTO errorDTO) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.content = content;
        this.postDTO = postDTO;
        this.errorDTO = errorDTO;
    }

    public CommentDTO() {
    }

    public CommentDTO(ErrorDTO errorDTO) {
        setErrorDTO(errorDTO);
    }

    public static CommentDTO createWithError(ErrorDTO errorDTO) {
        return new CommentDTO(errorDTO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
}
