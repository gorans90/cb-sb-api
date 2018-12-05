package com.carbook.http.server.exceptions.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Marko Pozdnjakov on 9/23/17.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Unauthorized extends RuntimeException {
  public Unauthorized(String message) {
    super(message);
  }
}
