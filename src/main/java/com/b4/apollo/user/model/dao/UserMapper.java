package com.b4.apollo.user.model.dao;

import com.b4.apollo.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(UserDTO newUser);

    void updateUser(UserDTO userDTO);


//    int idCheck(String userId);

//    int deleteUser(String userId);


    UserDTO loginUser(String username, String password);

    UserDTO userDetail(UserDTO userDTO);


    void deleteUser(UserDTO userDTO);

    UserDTO loginUser(String username);
}