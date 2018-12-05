package com.carbook.repositories.projects;

import com.carbook.models.projects.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gsimic on 10/21/2017.
 */
@Repository("imageRepository")
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select a from image a where a.project.id=:projectId")
    List<Image> findAllImagesByProject(@Param("projectId") Integer projectId);
}
