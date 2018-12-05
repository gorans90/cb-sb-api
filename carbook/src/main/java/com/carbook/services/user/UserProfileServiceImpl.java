package com.carbook.services.user;

import com.carbook.common.exception.user.UserProfileException;
import com.carbook.models.user.UserProfile;
import com.carbook.repositories.user.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by simic_000 on 5/22/2017.
 */

@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile save(UserProfile userProfile) throws UserProfileException {
//        if (userProfile.getFirstName().isEmpty() || userProfile.getLastName().isEmpty()) {
//            throw new UserProfileException("Please populate required fields");
//        }

        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findById(Integer id) throws UserProfileException {
        return userProfileRepository.findById(id).get();
    }

    @Override
    public UserProfile findByUserId(Integer id) throws UserProfileException {
        return userProfileRepository.findByUserId(id);
    }
}
