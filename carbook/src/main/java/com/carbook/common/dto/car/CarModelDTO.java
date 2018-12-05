package com.carbook.common.dto.car;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.enums.DefaultStatus;

/**
 * Created by simic_000 on 3/19/2017.
 */
public class CarModelDTO {
    private Integer id;
    private String name;
    private CarManufacturerDTO carManufacturer;
    private DefaultStatus active;
    private ErrorDTO error;

    public CarModelDTO() {
    }

    public CarModelDTO(Integer id, String name, CarManufacturerDTO carManufacturer, DefaultStatus active) {
        this.id = id;
        this.name = name;
        this.carManufacturer = carManufacturer;
        this.active = active;
    }

    private CarModelDTO(ErrorDTO error) {
        setError(error);
    }

    public static CarModelDTO createWithError(ErrorDTO error) {
        return new CarModelDTO(error);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarManufacturerDTO getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturerDTO carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public DefaultStatus getActive() {
        return active;
    }

    public void setActive(DefaultStatus active) {
        this.active = active;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || (!getClass().equals(obj.getClass()))) {
            return false;
        }

        final CarModelDTO other = (CarModelDTO) obj;
        if (other.getId() != this.getId()) {
            return false;
        } else if (!other.getName().equals(this.getName())) {
            return false;
        } else if (!other.getActive().equals(this.getActive())) {
            return false;
        } else if (!other.getCarManufacturer().equals(this.getCarManufacturer())) {
            return false;
        } else {
            return true;
        }
    }
}
