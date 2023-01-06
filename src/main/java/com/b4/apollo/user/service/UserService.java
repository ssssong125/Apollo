package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

public interface UserService {

    boolean insertUser(UserDTO newUser) throws Exception;

//    int idCheck(String userId);

    boolean updateUser(UserDTO updateDTO) throws Exception;

    void deleteUser(String userId) throws Exception;
}
