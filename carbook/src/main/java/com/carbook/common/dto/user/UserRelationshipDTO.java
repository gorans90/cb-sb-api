package com.carbook.common.dto.user;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.enums.user.UserRelationshipType;
import com.carbook.models.user.UserRelationship;

/**
 * Created by Marko Pozdnjakov on 5/4/17.
 */
public class UserRelationshipDTO {

  private UserDTO userOne;
  private UserDTO userTwo;
  private UserRelationshipType type;

  private ErrorDTO error;

  public UserRelationshipDTO(){}

  /**
   * Should be used if there is an error
   * @param error
   */
  private UserRelationshipDTO(ErrorDTO error){
    setError(error);
  }


  public static UserRelationshipDTO createWithError(ErrorDTO error){
    return new UserRelationshipDTO(error);
  }

  public static UserRelationshipDTO createFrom(UserRelationship userRelationship){
    UserRelationshipDTO dto = new UserRelationshipDTO();
    dto.setUserOne(UserConverter.toDTO(userRelationship.userOne));
    dto.setUserTwo(UserConverter.toDTO(userRelationship.userTwo));
    dto.setType(userRelationship.type);

    return dto;
  }

  public UserDTO getUserOne() {
    return userOne;
  }

  public void setUserOne(UserDTO userOne) {
    this.userOne = userOne;
  }

  public UserDTO getUserTwo() {
    return userTwo;
  }

  public void setUserTwo(UserDTO userTwo) {
    this.userTwo = userTwo;
  }

  public UserRelationshipType getType() {
    return type;
  }

  public void setType(UserRelationshipType type) {
    this.type = type;
  }

  public ErrorDTO getError() {
    return error;
  }

  public void setError(ErrorDTO error) {
    this.error = error;
  }
}
