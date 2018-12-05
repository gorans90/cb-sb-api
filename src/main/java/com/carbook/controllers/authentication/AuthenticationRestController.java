package com.carbook.controllers.authentication;

import com.carbook.common.util.http.AuthenticationHttpEndpoints;
import com.carbook.http.server.common.ResponseMessage;
import com.carbook.http.server.exceptions.general.BadRequestException;
import com.carbook.http.server.service.AbstractHttpService;
import com.carbook.jwt.JwtCredentials;
import com.carbook.jwt.JwtAuthDTO;
import com.carbook.jwt.JwtAuthenticationTokenFilter;
import com.carbook.jwt.JwtTokenService;
import com.carbook.jwt.JwtUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.carbook.http.server.exceptions.mapper.HTTPExceptionMapper.handle;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
@RequestMapping(AuthenticationHttpEndpoints.GENERAL)
@RestController
public class AuthenticationRestController extends AbstractHttpService {

  private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenService jwtTokenService;

  @Autowired
  private UserDetailsService userDetailsService;

  @Value("${jwt.header}")
  private String tokenHeader;

  @RequestMapping(value = AuthenticationHttpEndpoints.AUTHENTICATE, method = RequestMethod.POST)
  public ResponseMessage<JwtAuthDTO> createAuthenticationToken(
          @RequestBody JwtCredentials authenticationRequest/*,
          Device device*/) throws Exception {

    try {

//      logger.info("Request for authentication from device - {}", device );

      // Perform the security
      final Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      authenticationRequest.getUsername(),
                      authenticationRequest.getPassword()
              )
      );
      SecurityContextHolder.getContext().setAuthentication(authentication);

      // Reload password post-security so we can generate token
      final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
      JwtUser user = (JwtUser) userDetails;

      final String token = jwtTokenService.generateToken(userDetails);

      // Return the token
      return ok(new JwtAuthDTO(token)
              .withUsername(user.getUsername())
              .withUserId(user.getId())
              .withEmail(user.getEmail()));
    } catch (Exception e){
      logger.warn("Create auth token failed due to {}.", e.getLocalizedMessage());
      throw handle(e);
    }
  }


  @RequestMapping(value = AuthenticationHttpEndpoints.REFRESH_TOKEN, method = RequestMethod.POST)
  public ResponseMessage<JwtAuthDTO> refreshAndGetAuthenticationToken(
          @RequestBody JwtAuthDTO request/*,
          Device device*/)  throws Exception {
    try {

//      logger.info("Request for REFRESH TOKEN from device - {}", device );

      if(request.getToken() == null || request.getToken().isEmpty()){
        logger.error("Refresh token: token is missing");
        throw new BadRequestException("Refresh token: token is missing");
      }

      String token = request.getToken();

      if (jwtTokenService.canTokenBeRefreshed(token)) {
        String refreshedToken = jwtTokenService.refreshToken(token);

        if(refreshedToken == null || refreshedToken.isEmpty()){
          logger.error("Token cannot be refreshed");
          throw new BadRequestException("Token cannot be refreshed");
        }
        return ok(new JwtAuthDTO(refreshedToken));
      } else {
        throw new BadRequestException("Token has been expired");
      }
    }catch( Exception e){
      logger.warn("Create auth token failed due to {}.", e.getLocalizedMessage());
      e.printStackTrace();
      throw handle(e);
    }
  }

}
