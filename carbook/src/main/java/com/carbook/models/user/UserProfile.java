package com.carbook.models.user;

import com.carbook.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by simic_000 on 5/14/2017.
 */

@Entity(name = "userprofile")
public class UserProfile implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String city;

    @Column
    private String country;

    @OneToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserProfile(String city, String country, User user) {
            this.city = city;
        this.country = country;
        this.user = user;
    }

    public UserProfile() {

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
