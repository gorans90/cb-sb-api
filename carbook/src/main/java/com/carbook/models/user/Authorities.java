package com.carbook.models.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gsimic on 2/5/2017.
 */

@Entity(name = "authorities")
public class Authorities implements Serializable{

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String authority;

    @OneToOne
    private User user;

    public Authorities(Integer id, String username, String authority, User user) {
        this.id = id;
        this.username = username;
        this.authority = authority;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
