package com.carbook.jwt;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
public class JwtCredentials {
  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  public JwtCredentials() {
    super();
  }

  public JwtCredentials(String username, String password) {
    this.setUsername(username);
    this.setPassword(password);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
