package com.carbook.common.dto.user;

import com.carbook.models.user.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marko Pozdnjakov on 3/14/17.
 */
public class UserConverter {

  public static User fromDTO(UserDTO userDTO) {
    User user = new User();

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(userDTO, user);

    return user;
  }

  public static UserDTO toDTO(User user){
    return UserDTO.createFrom(user);
  }

  public static List<UserDTO> toDtoList(List<User> users){
    return users.stream().map(UserConverter::toDTO).collect(Collectors.toList());
  }
}
