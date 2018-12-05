package com.carbook.models.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gsimic on 2/6/2017.
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class UserLoginTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void loginWithValidUserThenAuthenticated() throws Exception {
//        FormLoginRequestBuilder login = formLogin()
//                .user("gsimic")
//                .password("redstar");
//
//        mockMvc.perform(login)
//                .andExpect(authenticated().withUsername("gsimic"));
//    }
//
//    @Test
//    public void loginWithInvalidUserThenAuthenticated() throws Exception {
//        FormLoginRequestBuilder login = formLogin()
//                .user("gsimic")
//                .password("redstar123");
//
//        mockMvc.perform(login)
//                .andExpect(unauthenticated());
//    }
//
//    @Test
//    public void accessUnsecuredResourceThenOk() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrlPattern("**/login"));
//    }
//
//    @Test
//    @WithMockUser
//    public void accessSecuredResourceAuthenticatedThenOk() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk());
//    }
}
