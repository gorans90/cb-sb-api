package com.carbook.repositories.post;

import com.carbook.models.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from post p where createdBy.id = :userId order by date_created desc")
    List<Post> getRecentPostsForUser(@Param("userId") Integer userId);
}
