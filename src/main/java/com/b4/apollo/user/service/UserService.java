package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

public interface UserService {

    void insertUser(UserDTO m);

    int idCheck(String userId);
}
