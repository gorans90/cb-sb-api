package com.carbook.common.dto.error;

/**
 * Created by Marko Pozdnjakov on 3/7/17.
 *
 * Error part of every DTO, if there is no error ErrorDTO should be null
 */
public class ErrorDTO {

  private String error;

  public ErrorDTO(String s){
    this.error = s;
  };

  public String getError() { return this.error; };

  public void setError(String error){ this.error = error; }


}
