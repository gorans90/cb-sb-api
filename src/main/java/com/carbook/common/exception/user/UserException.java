package com.carbook.common.exception.user;

import com.carbook.http.server.exceptions.general.BadRequestException;

/**
 * Created by simic_000 on 4/14/2017.
 */
public class UserException extends BadRequestException {
    public UserException(String exception) { super(exception); }
}
