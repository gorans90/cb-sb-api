package com.carbook.services.projects;

import com.carbook.models.car.CarProfile;
import com.carbook.models.projects.Image;
import com.carbook.models.projects.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by gsimic on 10/1/2017.
 */

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Value("${file.upload.root.path}")
    private String UPLOADED_FOLDER; //"C://temp//test//";  // needs to be dynamic

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ImageService imageService;

    @Override
    public void saveUploadedFiles(List<MultipartFile> files, CarProfile carProfile, Integer projectId) throws IOException {
        String folderPath = UPLOADED_FOLDER + "/" + carProfile.getId() + "/";
        if (projectId != null) {
            folderPath = folderPath + "/" + projectId;
        }
        Project project = null;
        if (projectId != null) {
            project = projectService.getProjectRepository().getOne(projectId);
        }
        File dir = new File(folderPath);
        logger.info("path is: " + folderPath);
        if (!dir.exists()) {
            dir.mkdirs();
            logger.info("new folder created");
        }
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folderPath + file.getOriginalFilename());
            Files.write(path, bytes);
            Image image = new Image();
            // if project id not sent default it to defaulted folder
            image.setProject(project == null ? projectService.getProjectRepository().findProjectByCarProfileId(carProfile.getId()) : project);
            image.setPath(path.toString());
            imageService.getImageRepository().save(image);
//            URL url = new URL(new URL("file:"), write.toString());
//            URI uri= null;
//            try {
//                uri = url.toURI();
//                logger.info("uri is: ", uri);
//            } catch (URISyntaxException e) {
//                logger.error("something went wrong with getting uri: ", e);
//            }
        }
    }
}
