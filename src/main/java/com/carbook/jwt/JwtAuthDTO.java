package com.carbook.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
public class JwtAuthDTO {

  private static final long serialVersionUID = 1250166508152483573L;

  @JsonProperty
  private Integer userId;
  @JsonProperty
  private String token;
  @JsonProperty
  private String userName;
  @JsonProperty

  private String email;

  public JwtAuthDTO() {}

  public JwtAuthDTO(String token){ this.token = token; }

  public JwtAuthDTO withUserId(Integer userId){
    this.userId = userId;
    return this;
  }

  public JwtAuthDTO withUsername(String username){
    this.userName = username;
    return this;
  }

  public JwtAuthDTO withEmail(String email){
    this.email = email;
    return this;
  }


  public String getToken() {
    return this.token;
  }
}
