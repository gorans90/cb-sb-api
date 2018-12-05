package com.carbook.services.user.operations.lister;

import com.carbook.common.dto.user.UserDTO;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marko Pozdnjakov on 8/6/17.
 */
@Service
public interface UserLister {

  List<UserDTO> getFiltered();
}
