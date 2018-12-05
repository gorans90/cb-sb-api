package com.carbook.common.dto.user;

import com.carbook.models.user.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Marko Pozdnjakov on 3/14/17.
 */
public class UserConverterTest {
  private Function<User, UserDTO> toDto = UserConverter::toDTO;
  private Function<List<User>, List<UserDTO>> toDtoList = UserConverter::toDtoList;
  private User userForValidate;
  private UserDTO userDtoForValidate;
  private List<User> usersForValidate;
  private List<UserDTO> usersDtoForValidate;

  @Before
  public void initiate(){
    usersForValidate = new ArrayList<>();
    usersDtoForValidate = new ArrayList<>();

    userForValidate = new User();
    userForValidate.setId(1);
    userForValidate.setEmail("test@gmail.com");

    usersForValidate.add(userForValidate);

    userDtoForValidate = new UserDTO();
    userDtoForValidate.setId(1);
    userDtoForValidate.setEmail("test@gmail.com");
  }

  @Test
  public void testToDto(){
    UserDTO userDto = toDto.apply(userForValidate);
    Assert.assertEquals("toDto - users are not same", userDto, userDtoForValidate);
  }

  @Test
  public void testToDtoList(){
    List<UserDTO> usersDto = toDtoList.apply(usersForValidate);
    Assert.assertEquals("toDto list - users are not same", usersDto.get(0), userDtoForValidate);
  }
}
