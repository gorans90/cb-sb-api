package com.carbook.common.exception.user;

import com.carbook.http.server.exceptions.general.BadRequestException;

/**
 * Created by simic_000 on 4/14/2017.
 */
public class UserProfileException extends BadRequestException {
    public UserProfileException(String exception) {
        super(exception);
    }
}
