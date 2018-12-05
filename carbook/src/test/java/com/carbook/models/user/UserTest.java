package com.carbook.models.user;

import com.carbook.repositories.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by gsimic on 12/1/2016.
 */

//@EnableAutoConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Test
//    public void userTests(){
//
//        User user = new User();
//        user.setEmail("simic.goran90@gmail.com");
//        assertNull(user.getId());//should be null
//        userRepository.save(user);
//
//        assertNotNull(user.getId());//should not be null
//    }
}
