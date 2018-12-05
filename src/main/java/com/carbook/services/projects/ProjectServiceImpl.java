package com.carbook.services.projects;

import com.carbook.models.projects.Project;
import com.carbook.repositories.projects.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gsimic on 11/4/2017.
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectRepository getProjectRepository () {
        return  projectRepository;
    }

    @Override
    public Project findProjectByCarProfileId(Integer carProfileId) {
            return projectRepository.findProjectByCarProfileId(carProfileId);
    }
}
