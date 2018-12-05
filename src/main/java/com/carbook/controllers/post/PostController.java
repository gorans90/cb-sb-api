package com.carbook.controllers.post;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.common.dto.post.PostConverter;
import com.carbook.common.dto.post.PostDTO;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.jwt.JwtTokenService;
import com.carbook.models.post.Post;
import com.carbook.services.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "post")
public class PostController extends AbstractHttpService {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    PostService postService;

    @Autowired
    JwtTokenService jwtTokenService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    ResponseMessage<PostDTO> create(@RequestBody PostDTO post) {
        try {
            if (post == null) {
                logger.error("Post json object is empty or invalid");
                return badRequest(PostDTO.createWithError(new ErrorDTO("Post json object is empty or invalid")));
            }

            Post created = postService.getRepository().save(PostConverter.fromDTO(post));

            return ok(PostConverter.toDTO(created));
        } catch (Exception e) {
            logger.error("Something went wrong in create post {}", e);
            return internalServerError(PostDTO.createWithError(new ErrorDTO("Something went wrong in create post")));
        }
    }

    @RequestMapping(value = "get/user/{userId}", method = RequestMethod.GET)
    ResponseMessage<?> getRecentPosts(@PathVariable(name = "userId") Integer userId) {
        try {

            // in the future user id should be taken from the session
            if (userId == null) {
                logger.error("User id cannot be null");
                return badRequest(PostDTO.createWithError(new ErrorDTO("User id cannot be null")));
            }

            List<Post> posts = postService.getRecentForUser(userId);

            List<PostDTO> postDTOS = new ArrayList<>();
            if (!posts.isEmpty()) {
                postDTOS = posts.stream().map(PostConverter::toDTO).collect(Collectors.toList());
            }

            return ok(postDTOS);
        } catch (Exception e) {
            logger.error("Something went wrong in the getRecent posts");
            return internalServerError(PostDTO.createWithError(new ErrorDTO("Something went wrong in the getRecent posts")));
        }
    }

    @RequestMapping(value = "get/{postId}", method = RequestMethod.GET)
    ResponseMessage<?> getPostById(@PathVariable(name = "postId") Integer postId) {
        try {
            if (postId == null) {
                logger.error("Post id cannot be null");
                return badRequest(PostDTO.createWithError(new ErrorDTO("Post id cannot be null")));
            }

            Post post = postService.getById(postId);

            if (post == null) {
                logger.info("Post with this id not found");
                return notFound(PostDTO.createWithError(new ErrorDTO("Post with this id not found")));
            }

            return ok(PostConverter.toDTO(post));
        } catch (Exception e) {
            logger.error("Something went wrong in the getPostById");
            return internalServerError(PostDTO.createWithError(new ErrorDTO("Something went wrong in the getPostById")));
        }
    }
}
