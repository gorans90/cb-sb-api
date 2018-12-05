package com.carbook.models.projects;

import com.carbook.models.car.CarProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by gsimic on 10/22/2017.
 */

@Entity(name = "project")
public class Project implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date createdDate;

    @ManyToOne
    private CarProfile carProfile;

    public Project() {};

    public Project(Integer id, String name, Date createdDate, CarProfile carProfile) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.carProfile = carProfile;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public CarProfile getCarProfile() {
        return carProfile;
    }

    public void setCarProfile(CarProfile carProfile) {
        this.carProfile = carProfile;
    }
}
