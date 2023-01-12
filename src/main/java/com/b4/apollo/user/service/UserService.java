package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

import javax.servlet.http.HttpSession;

public interface UserService {

    boolean insertUser(UserDTO newUser) throws Exception;


    boolean loginUser(UserDTO userDTO, HttpSession session);

    UserDTO userDetail(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);
    //    void deleteUser(String userId) throws Exception;

}
