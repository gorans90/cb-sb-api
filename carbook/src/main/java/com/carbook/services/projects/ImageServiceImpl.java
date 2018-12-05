package com.carbook.services.projects;

import com.carbook.models.projects.Image;
import com.carbook.repositories.projects.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gsimic on 11/4/2017.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    @Override
    public List<Image> getAllImagesForProject(Integer id) {
        return imageRepository.findAllImagesByProject(id);
    }
}
