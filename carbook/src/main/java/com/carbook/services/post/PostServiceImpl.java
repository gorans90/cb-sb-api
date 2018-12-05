package com.carbook.services.post;

import com.carbook.models.post.Post;
import com.carbook.repositories.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public PostRepository getRepository() {
        return postRepository;
    }

    @Override
    public List<Post> getRecentForUser(Integer id) {
        return postRepository.getRecentPostsForUser(id);
    }

    @Override
    public Post getById(Integer id) {
        return postRepository.findById(id).get();
    }
}
