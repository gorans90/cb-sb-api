package com.carbook.common.dto.user;

import com.carbook.models.user.UserRelationship;

/**
 * Created by Marko Pozdnjakov on 5/8/17.
 */
public class UserRelationshipConverter {

  public static UserRelationshipDTO toDTO(UserRelationship userRelationship){
    return UserRelationshipDTO.createFrom(userRelationship);
  }
}
