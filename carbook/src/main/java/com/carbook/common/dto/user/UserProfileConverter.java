package com.carbook.common.dto.user;

import com.carbook.models.user.UserProfile;
import org.modelmapper.ModelMapper;

/**
 * Created by simic_000 on 5/22/2017.
 */
public class UserProfileConverter {

    public static UserProfileDTO toDTO (UserProfile userProfile) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(userProfile, userProfileDTO);

        return userProfileDTO;
    }

    public static UserProfile fromDTO (UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();

        ModelMapper mapper = new ModelMapper();
        mapper.map(userProfileDTO, userProfile);

        return userProfile;
    }
}
