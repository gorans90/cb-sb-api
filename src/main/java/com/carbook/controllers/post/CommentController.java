package com.carbook.controllers.post;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.common.dto.post.CommentConverter;
import com.carbook.common.dto.post.CommentDTO;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.post.Comment;
import com.carbook.services.post.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comment")
public class CommentController extends AbstractHttpService{

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    ResponseMessage<CommentDTO> create(@RequestBody CommentDTO comment) {
        try {
            if (comment == null) {
                logger.error("Comment json object is empty or invalid");
                return badRequest(CommentDTO.createWithError(new ErrorDTO("Comment json object is empty or invalid")));
            }

            Comment created = commentService.getRepository().save(CommentConverter.fromDTO(comment));

            return ok(CommentConverter.toDTO(created));
        } catch (Exception e) {
            logger.error("Something went wrong in create comment {}", e);
            return internalServerError(CommentDTO.createWithError(new ErrorDTO("Something went wrong in create comment")));
        }
    }
}
