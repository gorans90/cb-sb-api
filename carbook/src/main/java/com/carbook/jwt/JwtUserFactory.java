package com.carbook.jwt;

import com.carbook.models.user.Authority;
import com.carbook.models.user.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
public class JwtUserFactory {

  private JwtUserFactory() {
  }

  public static JwtUser create(User user) {
    return new JwtUser(
        user.getId(),
        user.getUsername(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getPassword(),
        mapToGrantedAuthorities(user.getAuthorities()),
        user.isEnabled()
    );
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
    return authorities.stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getRole().name()))
        .collect(Collectors.toList());
  }
}
