package com.b4.apollo.user.service;

import com.b4.apollo.user.model.dto.UserDTO;

import javax.servlet.http.HttpSession;

public interface UserService {

    boolean insertUser(UserDTO newUser) throws Exception;

//    int idCheck(String userId);

//    void deleteUser(String userId) throws Exception;

    boolean loginUser(UserDTO userDTO, HttpSession session);

    UserDTO userDetail(UserDTO userDTO);

    void updateUser(UserDTO userDTO);



//    UserDTO loginUser(UserDTO userDTO);

//    UserDTO showUserInfo(String userId);

//    UserDTO findById(Long id);

//    Map<String, List<String>> getPermitListMap();
//    List<UserDTO> findAllUser();

}
