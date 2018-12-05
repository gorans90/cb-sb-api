package com.carbook.http.server.exceptions.general;

/**
 * Created by Marko Pozdnjakov on 12/13/17.
 */
public class HTTPServerException extends Exception{

  public HTTPServerException(String message){
    super(message);
  }
}
