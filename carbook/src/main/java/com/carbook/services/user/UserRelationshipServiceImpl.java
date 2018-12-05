package com.carbook.services.user;

import com.carbook.common.dto.user.UserRelationshipDTO;
import com.carbook.common.exception.user.UserException;
import com.carbook.models.user.User;
import com.carbook.models.user.UserRelationship;
import com.carbook.repositories.user.UserRelationshipRepository;
import com.carbook.repositories.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Marko Pozdnjakov on 5/3/17.
 */
public class UserRelationshipServiceImpl implements UserRelationshipService {

  private static final Logger logger = LoggerFactory.getLogger(UserRelationshipServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserRelationshipRepository userRelationshipRepository;

  @Override
  public UserRelationship create(UserRelationshipDTO userRelationshipDTO) throws UserException {

    UserRelationship userRelationship = new UserRelationship();

    User userOne = userRepository.findById(userRelationshipDTO.getUserOne().getId()).get();

    if(userOne == null){
      logger.error("user one not found");
      throw new UserException("user one not found");
    }

    User userTwo = userRepository.findById(userRelationshipDTO.getUserTwo().getId()).get();

    if(userTwo == null){
      logger.error("user two not found");
      throw new UserException("user two not found");
    }

    userRelationship.userOne = userOne;
    userRelationship.userTwo = userTwo;
    userRelationship.type = userRelationshipDTO.getType();


    userRelationship = userRelationshipRepository.save(userRelationship);
    return userRelationship;
  }
}
