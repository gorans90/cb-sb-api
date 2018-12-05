package com.carbook.services.user;

import com.carbook.common.dto.user.UserDTO;
import com.carbook.common.exception.user.UserException;
import com.carbook.models.user.User;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gsimic on 12/14/2016.
 */
@Service
public interface UserService {
    User save(User user) throws UserException;

    User findByUsername(String username);

    /**
     *
     * @param id
     * @return founded {@link User}
     */
    User findById(Long id);

    User findByEmail(String email);

    /**
     *
     * @return list of all user by filter
     */
//    TODO ADD UserSearchQuery
    List<UserDTO> getFilteredUsers();
}
