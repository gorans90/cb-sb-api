package com.carbook.common.dto.user;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.enums.Gender;
import com.carbook.models.user.User;

import java.util.Date;

/**
 * Created by Marko Pozdnjakov on 3/7/17.
 * Basic Data Transfer Object for {@link User}
 */
public class UserDTO {

  private Integer id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Gender gender;
  private Date dateOfBirth;
  private ErrorDTO error;

  public UserDTO(){}

  /**
   * Should be used if there is an error
   * @param error
   */
  private UserDTO(ErrorDTO error){
    setError(error);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ErrorDTO getError() {
    return error;
  }

  public void setError(ErrorDTO error) {
    this.error = error;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public static UserDTO createFrom(User user){
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setEmail(user.getEmail());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setDateOfBirth(user.getDateOfBirth());
    userDTO.setGender(user.getGender());
    return userDTO;
  }

  public static UserDTO createWithError(ErrorDTO error){
    return new UserDTO(error);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null || (!getClass().equals(obj.getClass()))){
      return false;
    }

    final UserDTO other = (UserDTO) obj;
    if(other.getId() != this.getId()){
      return false;
    }else if ( !other.getEmail().equals(this.getEmail())){
      return false;
    }else{
      return true;
    }
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
