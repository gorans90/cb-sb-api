package com.carbook.common.dto.user;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.enums.Gender;

import java.util.Date;

/**
 * Created by simic_000 on 5/17/2017.
 */
public class UserProfileDTO {
    private Integer id;
    private String city;
    private String country;
    private UserDTO userDTO;
    private ErrorDTO error;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String city, String country, UserDTO userDTO, ErrorDTO errorDTO) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.userDTO = userDTO;
        this.error = errorDTO;
    }

    private UserProfileDTO(ErrorDTO error) {
        setError(error);
    }

    public static UserProfileDTO createWithError(ErrorDTO error) {
        return new UserProfileDTO(error);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO errorDTO) {
        this.error = errorDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
