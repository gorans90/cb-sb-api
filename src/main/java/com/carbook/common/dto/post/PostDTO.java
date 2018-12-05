package com.carbook.common.dto.post;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.common.dto.user.UserDTO;

import java.util.Date;
import java.util.Set;

public class PostDTO {
    private Integer id;
    private String title;
    private UserDTO createdBy;
    private Date dateCreated;
    private String content;
    private Set<CommentDTO> commentDTOs;
    private ErrorDTO errorDTO;

    public PostDTO(Integer id, String title, UserDTO createdBy, Date dateCreated, String content, Set<CommentDTO> commentDTOs, ErrorDTO errorDTO) {
        this.id = id;
        this.title = title;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.content = content;
        this.commentDTOs = commentDTOs;
        this.errorDTO = errorDTO;
    }

    public PostDTO() {
    }

    public PostDTO(ErrorDTO errorDTO) {
        setErrorDTO(errorDTO);
    }

    public static PostDTO createWithError(ErrorDTO errorDTO) {
        return new PostDTO(errorDTO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<CommentDTO> getCommentDTOs() {
        return commentDTOs;
    }

    public void setCommentDTOs(Set<CommentDTO> commentDTOs) {
        this.commentDTOs = commentDTOs;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
}
