package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

import javax.servlet.http.HttpSession;

public interface UserService /*extends UserDetailsService*/ {

    boolean insertUser(UserDTO newUser) throws Exception;

    UserDTO userDetail(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    boolean loginUser(UserDTO userDTO, HttpSession session);
    //    void deleteUser(String userId) throws Exception;

//    void joinUser(UserDTO userDto);

//    UserDTO loadUserByUsername(String username, String password) throws UsernameNotFoundException;


//    UserDTO loginUser(String username);


//    UserDTO loginUser(UserDTO userDTO);
}
