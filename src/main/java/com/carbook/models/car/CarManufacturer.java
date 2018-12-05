package com.carbook.models.car;

import com.carbook.enums.DefaultStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gsimic on 11/29/2016.
 * Class CarManufacturer will hold names of car manufacturers
 */

@Entity(name = "carmanufacturer")
public class CarManufacturer implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = false, nullable = false)
    public String name;

    @Column
    public String code;

    @Column
    @Enumerated(EnumType.STRING)
    public DefaultStatus active;

    public CarManufacturer() {
    }

    public CarManufacturer(Integer id, String name, String code, DefaultStatus active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

        final CarManufacturer other = (CarManufacturer) obj;
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
