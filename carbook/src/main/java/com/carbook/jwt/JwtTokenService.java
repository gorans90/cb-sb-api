package com.carbook.jwt;

import com.carbook.common.util.time.TimeProvider;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
@Component
public class JwtTokenService {

  private static final long serialVersionUID = -3301605591108950415L;

  private static org.slf4j.Logger logger = LoggerFactory.getLogger(JwtTokenService.class);

  static final String CLAIM_KEY_USER = "sub";
  static final String CLAIM_KEY_CREATED = "created";
  static final String CLAIM_KEY_EXPIRED = "exp";


  @Autowired
  private TimeProvider timeProvider;

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private Long expiration;

  public String getUserFromToken(String token) {
    String email;
    try {
      final Claims claims = getClaimsFromToken(token);
      email = claims.getSubject();
    } catch (Exception e) {
      email = null;
    }
    return email;
  }


  public Date getExpirationDateFromToken(String token) {
    Date expiration;
    try {
      final Claims claims = getClaimsFromToken(token);
      expiration = new Date((Long) claims.get(CLAIM_KEY_EXPIRED));
    } catch (Exception e) {
      expiration = null;
    }
    return expiration;
  }

  private Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token)
          .getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  public Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(timeProvider.now());
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();

    claims.put(CLAIM_KEY_USER, userDetails.getUsername());
    final Date createdDate = timeProvider.now();
    claims.put(CLAIM_KEY_CREATED, createdDate);
    final Date expirationDate = new Date(createdDate.getTime() + expiration * 60 * 1000);
    claims.put(CLAIM_KEY_EXPIRED, expirationDate);


    return doGenerateToken(claims);
  }

  private String doGenerateToken(Map<String, Object> claims) {
    return Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    JwtUser user = (JwtUser) userDetails;
    final String username = getUserFromToken(token);
    return username.equals(user.getUsername()) && !isTokenExpired(token);
  }

  public Boolean canTokenBeRefreshed(String token) {
    return !isTokenExpired(token);
  }

  public String refreshToken(String token) {
    String refreshedToken;
    try {
      final Claims claims = getClaimsFromToken(token);
      final Date createdDate = timeProvider.now();
      claims.put(CLAIM_KEY_CREATED, createdDate);
      claims.put(CLAIM_KEY_EXPIRED, new Date(createdDate.getTime() + expiration * 60 * 1000));

      refreshedToken = doGenerateToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

}
