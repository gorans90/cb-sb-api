package com.carbook.models.car;

import com.carbook.enums.DefaultStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gsimic on 11/30/2016.
 */

@Entity(name = "carmodel")
public class CarModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = false, nullable = false)
    public String name;

    /**
     * Specific model can belong to only one manufacturer
     */
    @OneToOne
    public CarManufacturer carManufacturer;

    /**
     * Status can be active or inactive
     */
    @Column
    @Enumerated(EnumType.STRING)
    public DefaultStatus active;

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

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
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

        final CarModel other = (CarModel) obj;
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
