package com.carbook.services.projects;

import com.carbook.models.projects.Project;
import com.carbook.repositories.projects.ProjectRepository;

/**
 * Created by gsimic on 11/4/2017.
 */
public interface ProjectService {
    ProjectRepository getProjectRepository();
    Project findProjectByCarProfileId(Integer carProfileId);
}
