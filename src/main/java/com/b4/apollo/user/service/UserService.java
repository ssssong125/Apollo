package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

public interface UserService {

    boolean insertUser(UserDTO newUser);

    int idCheck(String userId);
}
