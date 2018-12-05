package com.carbook.common.dto.car;

import com.carbook.common.dto.error.ErrorDTO;
import com.carbook.enums.DefaultStatus;

/**
 * Created by simic_000 on 3/19/2017.
 */
public class CarManufacturerDTO {
    private Integer id;
    private String name;
    private String code;
    private DefaultStatus active;
    private ErrorDTO error;

    public CarManufacturerDTO() {

    }

    public CarManufacturerDTO(Integer id, String name, String code, DefaultStatus active, ErrorDTO error) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
        this.error = error;
    }

    private CarManufacturerDTO(ErrorDTO errorDTO) {
        setError(errorDTO);
    }

    public static CarManufacturerDTO createWithError(ErrorDTO error) {
        return new CarManufacturerDTO(error);
    }

    public DefaultStatus getActive() {
        return active;
    }

    public void setActive(DefaultStatus active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        final CarManufacturerDTO other = (CarManufacturerDTO) obj;
        if (other.getId() != this.getId()) {
            return false;
        } else if (!other.getCode().equals(this.getCode())) {
            return false;
        } else if (!other.getName().equals(this.getName())) {
            return false;
        } else if (!other.getActive().equals(this.getActive())) {
            return false;
        } else {
            return true;
        }
    }
}
