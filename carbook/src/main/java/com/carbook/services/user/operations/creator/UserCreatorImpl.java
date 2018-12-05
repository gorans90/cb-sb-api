package com.carbook.services.user.operations.creator;

import com.carbook.common.exception.user.UserException;
import com.carbook.enums.user.UserRole;
import com.carbook.models.user.Authority;
import com.carbook.models.user.User;
import com.carbook.repositories.user.AuthorityRepository;
import com.carbook.repositories.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko Pozdnjakov on 8/6/17.
 */
@Service
public class UserCreatorImpl implements UserCreator{

  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) throws UserException {
    User existing = userRepository.findByEmail(user.getEmail());

    if (existing != null) {
      throw new UserException("This email is already in use.");
    }

    // default username will be first part of email
    String[] emailParts = user.getEmail().split("@");
    user.setUsername(emailParts[0]);
    user.setEnabled(true);

    List<Authority> authorityList = new ArrayList<>();
    authorityList.add(new Authority(UserRole.ROLE_USER));

    User regUser = userRepository.save(user);

    return regUser;
  }

}
