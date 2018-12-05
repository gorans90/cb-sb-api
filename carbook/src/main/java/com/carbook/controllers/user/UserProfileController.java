package com.carbook.controllers.user;

import com.carbook.common.dto.user.UserProfileConverter;
import com.carbook.common.dto.user.UserProfileDTO;
import com.carbook.common.exception.user.UserProfileException;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.exceptions.general.NotFoundException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.user.UserProfile;
import com.carbook.services.user.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by simic_000 on 5/22/2017.
 */

@RestController
@RequestMapping(value = "/userprofile")
public class UserProfileController extends AbstractHttpService {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseMessage<UserProfileDTO> create(@RequestBody UserProfileDTO userProfile) throws Exception{
        try {

            logger.info("test - merge - 1");
//            if (userProfile.getFirstName().isEmpty() || userProfile.getLastName().isEmpty() || userProfile.getUserDTO() == null) {
//                logger.warn("Invalid user profile DTO");
//                throw new BadRequestException("Invalid user profile DTO");
//            }

            UserProfile profileForUser = userProfileService.findByUserId(userProfile.getUserDTO().getId());
            if (profileForUser != null) {
                throw new BadRequestException("Profile already exists");
            }

            UserProfile userProfileFromDTO = UserProfileConverter.fromDTO(userProfile);
            userProfileFromDTO = userProfileService.save(userProfileFromDTO);
            return  ok(UserProfileConverter.toDTO(userProfileFromDTO));
        } catch (UserProfileException e) {
            logger.warn("Create user profile failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    ResponseMessage<UserProfileDTO> getById(@PathVariable(name = "id") Integer profileId) throws Exception{
        try {

            if(profileId == null){
                logger.error("Missing parameter profileId!");
                throw new BadRequestException("Missing parameter profileId!");
            }

            UserProfile profile = userProfileService.findById(profileId);
            if (profile == null) {
                logger.warn("We did not find profile with provided id");
                throw new NotFoundException("User profile not found");
            }

            return ok(UserProfileConverter.toDTO(profile));
        } catch (UserProfileException e) {
            logger.warn("Get user profile by profile id failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
    ResponseMessage<UserProfileDTO> getByUserId(@PathVariable(name = "id") Integer userId) throws Exception {
        try {

            if(userId == null){
                logger.error("Missing parameter userId!");
                throw new BadRequestException("Missing parameter userId!");
            }

            UserProfile profile = userProfileService.findByUserId(userId);
            if (profile == null) {
                logger.warn("User profile not found with provided id");
                throw new NotFoundException("User profile not found");
            }

            return ok(UserProfileConverter.toDTO(profile));
        } catch (UserProfileException e) {
            logger.warn("Get user profile by user id failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }
}
