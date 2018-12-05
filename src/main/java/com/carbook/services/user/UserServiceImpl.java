package com.carbook.services.user;

import com.carbook.common.dto.user.UserDTO;
import com.carbook.common.exception.user.UserException;
import com.carbook.models.user.User;
import com.carbook.repositories.user.UserRepository;
import com.carbook.services.user.operations.UserOperationFactory;
import com.carbook.services.user.operations.creator.UserCreator;
import com.carbook.services.user.operations.lister.UserLister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserOperationFactory userOperationFactory;

    @Override
    public User save(User user) throws UserException {
        UserCreator creator = userOperationFactory.getCreator();
        return creator.create(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id.intValue()).get();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<UserDTO> getFilteredUsers() {
        UserLister userLister = userOperationFactory.getLister();
        return userLister.getFiltered();
    }
}
