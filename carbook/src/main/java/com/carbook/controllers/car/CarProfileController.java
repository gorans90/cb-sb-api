package com.carbook.controllers.car;

import com.carbook.common.dto.car.CarProfileConverter;
import com.carbook.common.dto.car.CarProfileDTO;
import com.carbook.enums.DefaultStatus;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.exceptions.general.NotFoundException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.car.CarProfile;
import com.carbook.models.user.User;
import com.carbook.services.car.CarProfileService;
import com.carbook.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by simic_000 on 3/19/2017.
 */

@RestController
public class CarProfileController extends AbstractHttpService {

    private static final Logger logger = LoggerFactory.getLogger(CarProfileController.class);

    @Autowired
    private CarProfileService carProfileService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "profiles/all", method = RequestMethod.GET)
    ResponseMessage<List<CarProfileDTO>> getAllProfilesForLoggedInUser() throws Exception {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null) {
                logger.error("Something wrong with authentication");
                throw new BadRequestException("Something wrong with authentication");
            }

            User user = userService.findByUsername(auth.getName());

            List<CarProfile> carProfiles = carProfileService.findAllForLoggedInUser(user.getId());

            if (carProfiles == null) {
                logger.warn("We did not find any profile for logged in user");
                throw new NotFoundException("We did not find any profile for logged in user");
            }

            return ok(CarProfileConverter.toDTOList(carProfiles));
        } catch (Exception e) {
            logger.warn("get profiles failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "profile/{id}", method = RequestMethod.GET)
    ResponseMessage<CarProfileDTO> getProfileById(@PathVariable(name = "id") Integer id) throws Exception {
        try {
            CarProfile carProfile = carProfileService.getRepository().findById(id).get();

            if (carProfile == null) {
                logger.warn("We did not find profile with provided id");
                throw new NotFoundException("Car profile not found");
            }

            return ok(CarProfileConverter.toDTO(carProfile));
        } catch (Exception e) {
            logger.warn("get get profile by ID failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    ResponseMessage<CarProfileDTO> create(@RequestBody CarProfileDTO car) throws Exception {
        try {
            if (car == null) {
                logger.error("Something went wrong with json object");
                throw new BadRequestException("Something went wrong with json objec");
            }

            CarProfile carProfile = carProfileService.getRepository().save(CarProfileConverter.fromDTO(car));

            return ok(CarProfileConverter.toDTO(carProfile));
        } catch (Exception e) {
            logger.warn("Create car profile failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "profile/update/{id}", method = RequestMethod.POST)
    ResponseMessage<CarProfileDTO> update(
        @PathVariable(name = "id") Integer id,
        @RequestBody CarProfileDTO car) throws Exception{
        try {
            if (car == null || id == null || car.getId() != id) {
                logger.error("Something went wrong with json object or url variable");
                throw new BadRequestException("Something went wrong with json object or url variable");
            }

            CarProfile carProfile = carProfileService.getRepository().findById(id).get();

            if (carProfile == null) {
                logger.error("No profile found with provided id");
                throw new NotFoundException("No profile found with provided id");
            }

            carProfile = carProfileService.getRepository().save(CarProfileConverter.fromDTO(car));

            return ok(CarProfileConverter.toDTO(carProfile));
        } catch (Exception e) {
            logger.warn("Update car profile failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

    @RequestMapping(value = "profile/delete/{id}", method = RequestMethod.POST)
    ResponseMessage<String> delete(@PathVariable(name = "id") Integer id) throws Exception {
        try {
            if (id == null) {
                logger.error("Something went wrong with url variable");
                throw new BadRequestException("Something went wrong with url variable");
            }

            CarProfile carProfile = carProfileService.getRepository().findById(id).get();

            if (carProfile == null) {
                logger.error("No profile found with provided id");
                throw new NotFoundException("No profile found with provided id");
            }

            carProfile.setActive(DefaultStatus.INACTIVE);
            carProfileService.getRepository().save(carProfile);

            return ok("Profile successful deleted!");
        } catch (Exception e ){
            logger.warn("Delete car profile failed due to {}.", e.getLocalizedMessage());
            throw handle(e);
        }
    }

}
