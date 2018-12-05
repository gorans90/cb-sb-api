package com.carbook.repositories.projects;

import com.carbook.models.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gsimic on 11/4/2017.
 */
@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("select a from project a where a.carProfile.id=:carProfileId")
    Project findProjectByCarProfileId(@Param("carProfileId") Integer carProfileId);
}
