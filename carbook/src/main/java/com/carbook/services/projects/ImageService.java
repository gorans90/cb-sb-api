package com.carbook.services.projects;

import com.carbook.models.projects.Image;
import com.carbook.repositories.projects.ImageRepository;

import java.util.List;

/**
 * Created by gsimic on 11/4/2017.
 */
public interface ImageService {
    ImageRepository getImageRepository();
    List<Image> getAllImagesForProject(Integer id);
}
