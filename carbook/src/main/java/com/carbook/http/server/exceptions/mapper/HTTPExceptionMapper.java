package com.carbook.http.server.exceptions.mapper;

import com.carbook.http.server.exceptions.response.BadRequest;
import com.carbook.http.server.exceptions.response.NotFound;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.exceptions.response.InternalServerError;
import com.carbook.http.server.exceptions.general.NotFoundException;


/**
 * Created by Marko Pozdnjakov on 9/23/17.
 */
public class HTTPExceptionMapper {

  /*
   * Provides http error response if there is an exception
   * while processing some request
   */
  public static Exception handle(Exception e){
    if(e instanceof BadRequestException){
      throw new BadRequest(e.getLocalizedMessage());
    } else if(e instanceof NotFoundException){
      throw new NotFound(e.getLocalizedMessage());
    } else {
      throw new InternalServerError("test");
    }
  }
}
