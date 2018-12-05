package com.carbook.services.user.operations.lister;

import com.carbook.common.dto.user.UserConverter;
import com.carbook.common.dto.user.UserDTO;
import com.carbook.repositories.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marko Pozdnjakov on 8/6/17.
 */
@Service
public class UserListerImpl implements  UserLister {

  @Autowired
  private UserRepository userRepository;


  @Override
  public List<UserDTO> getFiltered() {
    return UserConverter.toDtoList(userRepository.findAll());
  }
}
