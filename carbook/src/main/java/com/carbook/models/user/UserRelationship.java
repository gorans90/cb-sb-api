package com.carbook.models.user;

import com.carbook.enums.user.UserRelationshipType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marko Pozdnjakov on 5/3/17.
 */
@Entity(name = "userrelationship")
public class UserRelationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public User userOne;
    public User userTwo;
    public UserRelationshipType type = UserRelationshipType.FRIENDS;

    public UserRelationship(){}

}
