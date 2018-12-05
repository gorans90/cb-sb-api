package com.carbook.controllers.user;

import com.carbook.common.dto.user.UserConverter;
import com.carbook.common.dto.user.UserDTO;
import com.carbook.common.util.http.UserHttpEndpoints;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.exceptions.general.NotFoundException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.user.User;
import com.carbook.services.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by gsimic on 12/14/2016.
 */

@RestController
@RequestMapping(value = UserHttpEndpoints.USER)
public class UserController extends AbstractHttpService {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
  ResponseMessage<UserDTO> getSingle(@PathVariable Long userId) throws Exception {
    try{
      logger.info("UserController#getSinle method - CALLED.");
      if(userId == null){
        logger.error("Missing parameter userId!");
        throw new BadRequestException("Missing parameter userId!");
      }

      if(userId < 1){
        logger.warn("User id must be an positive integer!");
        throw new BadRequestException("User id must be an positive integer!");
      }

      User user = userService.findById(userId);

      if(user == null){
        logger.warn("User with id: " + userId + " - NOT FOUND!");
        throw new NotFoundException("User with id: " + userId + " - NOT FOUND!");

      }
      return ok(UserDTO.createFrom(user));
    }catch (Exception e){
      logger.warn("Getting user by user ID failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }

  @RequestMapping(value = UserHttpEndpoints.CREATE, method = RequestMethod.POST)
  ResponseMessage<UserDTO> create(@RequestBody UserDTO user) throws Exception {

    if (user.getEmail() == null || user.getPassword() == null) {
      throw new BadRequestException("Email or password cannot be null");
    }

    try {
      User userFromDTO = UserConverter.fromDTO(user);
      userFromDTO.setPassword(passwordEncoder().encode(user.getPassword()));

      User registered = userService.save(userFromDTO);
      logger.info("successfully registered user");
      return ok(UserConverter.toDTO(registered));
    } catch (Exception e) {
      logger.warn("Create user failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }



}

