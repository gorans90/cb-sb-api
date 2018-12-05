package com.carbook.services.user.operations.creator;

import com.carbook.common.exception.user.UserException;
import com.carbook.models.user.User;

import org.springframework.stereotype.Service;

/**
 * Created by Marko Pozdnjakov on 8/6/17.
 */
@Service
public interface UserCreator {

  /**
   * Create an user
   * @param user
   * @return
   */
  User create(User user)  throws UserException;
}
