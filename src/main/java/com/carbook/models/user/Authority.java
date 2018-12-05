package com.carbook.models.user;


import com.carbook.enums.user.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity(name = "authority")
public class Authority implements Serializable{

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;


    public Authority(UserRole role){
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
