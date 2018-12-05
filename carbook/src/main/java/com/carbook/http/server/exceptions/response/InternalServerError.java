package com.carbook.http.server.exceptions.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Marko Pozdnjakov on 9/23/17.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerError extends RuntimeException {
  public InternalServerError(String message) {
    super(message);
  }
}
