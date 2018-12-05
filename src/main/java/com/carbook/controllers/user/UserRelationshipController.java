package com.carbook.controllers.user;

import com.carbook.common.dto.user.UserRelationshipConverter;
import com.carbook.common.dto.user.UserRelationshipDTO;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.exceptions.general.NotFoundException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.models.user.UserRelationship;
import com.carbook.services.user.UserRelationshipService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by Marko Pozdnjakov on 5/3/17.
 */
public class UserRelationshipController extends AbstractHttpService {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRelationshipService userRelationshipService;

  @RequestMapping(
      value = "user/relationship/create",
      method = RequestMethod.POST
  )
  ResponseMessage<UserRelationshipDTO> create(@RequestBody UserRelationshipDTO userRelationshipDTO) throws Exception{
    try {

      if(userRelationshipDTO.getUserOne() == null || userRelationshipDTO.getUserTwo() == null
          || userRelationshipDTO.getUserOne().getId() == null || userRelationshipDTO.getUserTwo().getId() == null
          || userRelationshipDTO.getType() == null){
        logger.error("invalid relationships parameters");
        throw new BadRequestException("Invalid relationships parameters!");
      }

      UserRelationship userRelationship = userRelationshipService.create(userRelationshipDTO);
      if(userRelationship == null){
        logger.warn("userRelationship - NOT FOUND!");
        throw new NotFoundException("userRelationship - NOT FOUND!");
      }

      return ok(UserRelationshipConverter.toDTO(userRelationship));
    } catch (Exception e) {
      logger.warn("Create user relationship failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }

  @RequestMapping(
      value = "user/relationship/update",
      method = RequestMethod.POST
  )
  ResponseMessage<UserRelationshipDTO> update(@RequestBody UserRelationshipDTO relationshipDTO) throws Exception{
    try {
      return ok(new UserRelationshipDTO());
    } catch (Exception e) {
      logger.warn("Update user relationship failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }

  /**
   * SHould return all relationships for userOne, by types
   * @param relationshipDTO
   * @param userOneId
   * @param types
   * @return
   */
  @RequestMapping(
      value = "user/relationship/get",
      method = RequestMethod.GET
  )
  ResponseMessage<?> getAllByUserOneAndStatuses(
      @RequestBody UserRelationshipDTO relationshipDTO,
      @RequestParam("userOneId") long userOneId,
      @RequestParam("types") List<String> types) throws Exception{
    try {
      List<UserRelationshipDTO> relationshipDTOs = new ArrayList<>();
      return ok(relationshipDTOs);
    } catch (Exception e) {
      logger.warn("Get list of user relationships failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }

  @RequestMapping(
      value = "user/relationship/get",
      method = RequestMethod.POST
  )
  ResponseMessage<UserRelationshipDTO> getSingle(@RequestBody UserRelationshipDTO relationshipDTO) throws Exception{
    try {
      return ok(new UserRelationshipDTO());
    } catch (Exception e) {
      logger.warn("Get user relationships by body failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }
}
