package com.carbook.services.user;

import com.carbook.common.exception.user.UserProfileException;
import com.carbook.models.user.UserProfile;

/**
 * Created by simic_000 on 5/22/2017.
 */
public interface UserProfileService {

    UserProfile save(UserProfile userProfile) throws UserProfileException;

    UserProfile findById(Integer id) throws UserProfileException;

    UserProfile findByUserId(Integer id) throws UserProfileException;
}
