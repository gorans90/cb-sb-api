package com.carbook.services.user;

import com.carbook.common.dto.user.UserRelationshipDTO;
import com.carbook.common.exception.user.UserException;
import com.carbook.models.user.UserRelationship;

/**
 * Created by Marko Pozdnjakov on 5/3/17.
 */
public interface UserRelationshipService {

  UserRelationship create(UserRelationshipDTO userRelationshipDTO) throws UserException;
}
