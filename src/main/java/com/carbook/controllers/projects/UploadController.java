package com.carbook.controllers.projects;

import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.car.CarProfile;
import com.carbook.models.projects.Image;
import com.carbook.services.projects.ImageService;
import com.carbook.services.projects.UploadService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by gsimic on 9/10/2017.
 */

@RestController
@RequestMapping(value = "/upload")
public class UploadController extends AbstractHttpService {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/single")
    public ResponseMessage<String> singleFileUpload (
        @RequestParam("file") MultipartFile uploadfile,
        @RequestParam("carProfile") CarProfile carProfile,
        @RequestParam(value = "projectId", required = false) Integer projectId) throws Exception {

        try {
            logger.debug("Single file upload!", carProfile);

            if (uploadfile.isEmpty()) {
                logger.warn("FIle is missing");
                throw new BadRequestException("Please select a file!");
            }

            // TODO add getting userId from the session
            uploadService.saveUploadedFiles(Arrays.asList(uploadfile), carProfile, projectId);

            return  ok("Successfully uploaded - " + uploadfile.getOriginalFilename());
        } catch (Exception e){
            logger.warn("Upload single file failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @PostMapping("/multiple")
    public ResponseMessage<String> multipleFileUpload (
        @RequestParam("files") MultipartFile[] uploadfiles,
        @RequestParam("carProfile") CarProfile carProfile,
        @RequestParam(value = "projectId", required = false) Integer projectId) throws Exception{

        try{
            logger.debug("Multiple file upload!");

            // TODO add getting userId from the session
            // Get file name
            String uploadedFileName = Arrays.stream(uploadfiles)
                .map(MultipartFile::getOriginalFilename)
                .filter(x -> !StringUtils.isEmpty(x))
                .collect(Collectors.joining(" , "));

            if (StringUtils.isEmpty(uploadedFileName)) {
                logger.warn("FIle is missing");
                throw new BadRequestException("Please select a file!");
            }

            uploadService.saveUploadedFiles(Arrays.asList(uploadfiles), carProfile, projectId);

            return ok("Successfully uploaded - " + uploadedFileName);
        } catch (Exception e){
            logger.warn("Upload multiple file failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

//    @GetMapping("/get-image/{id}")
//    public ResponseMessage<List<String>> getImagesByProjectTest(
//        @PathVariable(name = "id") Integer id) throws Exception {
//
//        try {
//            List<Image> images = imageService.getAllImagesForProject(id);
//            List<String> encodedfiles = new ArrayList<>();
//            for (Image image : images) {
//                Path path = Paths.get(image.getPath());
//                byte[] bytes = Files.readAllBytes(path);
//                String encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
//                encodedfiles.add(encodedfile);
//            }
//            return ok(encodedfiles);
//        }catch (Exception e){
//            logger.warn("get images by project failed due to {}.", e.getLocalizedMessage());
//            throw handle(e);
//        }
//    }

    @GetMapping("/get-image/{id}")
    public ResponseEntity<List<String>> getImagesByProject(@PathVariable(name = "id") Integer id) throws Exception {
        try {
            List<Image> images = imageService.getAllImagesForProject(id);
            List<String> encodedfiles = new ArrayList<>();
            for (Image image : images) {
                Path path = Paths.get(image.getPath());
                byte[] bytes = Files.readAllBytes(path);
                String encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
                encodedfiles.add(encodedfile);
            }
            return new ResponseEntity<>(encodedfiles, HttpStatus.OK);
        }catch (Exception e){
            logger.warn("get images by project failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

}
