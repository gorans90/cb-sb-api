package com.carbook.common.dto.car;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.common.dto.user.UserDTO;
import com.carbook.enums.DefaultStatus;
import com.carbook.models.car.CarProfile;
/**
 * Created by simic_000 on 3/19/2017.
 * Basic Data Transfer Object for {@link CarProfile)
 */
public class CarProfileDTO {
    private Integer id;
    private long ccm;
    private long yearOfProduction;
    private int hp;
    private Boolean primaryCar;
    private CarModelDTO carModel;
    private UserDTO user;
    private DefaultStatus active;
    private ErrorDTO error;

    public CarProfileDTO() {
    }

    public CarProfileDTO(Integer id, long ccm, long yearOfProduction, int hp, Boolean primaryCar, CarModelDTO carModel, UserDTO user, DefaultStatus active, ErrorDTO error) {
        this.id = id;
        this.ccm = ccm;
        this.yearOfProduction = yearOfProduction;
        this.hp = hp;
        this.primaryCar = primaryCar;
        this.carModel = carModel;
        this.user = user;
        this.active = active;
        this.error = error;
    }

    private CarProfileDTO(ErrorDTO error) {
        setError(error);
    }

    public static CarProfileDTO createWithError(ErrorDTO error) {
        return new CarProfileDTO(error);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCcm() {
        return ccm;
    }

    public void setCcm(long ccm) {
        this.ccm = ccm;
    }

    public long getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(long yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Boolean getPrimaryCar() {
        return primaryCar;
    }

    public void setPrimaryCar(Boolean primaryCar) {
        this.primaryCar = primaryCar;
    }

    public CarModelDTO getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModelDTO carModel) {
        this.carModel = carModel;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    public DefaultStatus getActive() {
        return active;
    }

    public void setActive(DefaultStatus active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || (!getClass().equals(obj.getClass()))) {
            return false;
        }

        final CarProfileDTO other = (CarProfileDTO) obj;
        if (other.getId() != this.getId()) {
            return false;
        } else if (!other.getPrimaryCar().equals(this.getPrimaryCar())) {
            return false;
        } else if (!other.getActive().equals(this.getActive())) {
            return false;
        } else if (other.getCcm() != this.getCcm()) {
            return false;
        } else if (other.getHp() != this.getHp()) {
            return false;
        } else if (other.getYearOfProduction() != this.getYearOfProduction()) {
            return false;
        } else if (other.getHp() != this.getHp()) {
            return false;
        } else if (!other.getCarModel().equals(this.getCarModel())) {
            return false;
        } else if (!other.getUser().equals(this.getUser())) {
            return false;
        } else {
            return true;
        }
    }
}
