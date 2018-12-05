package com.carbook.services.post;

import com.carbook.repositories.post.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentRepository getRepository() {
        return commentRepository;
    }
}
