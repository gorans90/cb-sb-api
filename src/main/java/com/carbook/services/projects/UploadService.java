package com.carbook.services.projects;

import com.carbook.models.car.CarProfile;
import com.carbook.models.projects.Project;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by gsimic on 10/1/2017.
 */
public interface UploadService {
    void saveUploadedFiles(List<MultipartFile> files, CarProfile carProfile, Integer projectId) throws IOException;
}
