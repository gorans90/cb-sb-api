package com.carbook.services.post;

import com.carbook.models.post.Post;
import com.carbook.repositories.post.PostRepository;

import java.util.List;

public interface PostService {

    PostRepository getRepository();
    List<Post> getRecentForUser(Integer id);
    Post getById(Integer id);
}
