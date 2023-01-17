package com.b4.apollo.user.model.dao;

import com.b4.apollo.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpSession;

@Mapper
public interface UserMapper {

    int insertUser(UserDTO newUser);

    void updateUser(UserDTO userDTO);

    UserDTO loginUser(String userId, String password);

    UserDTO userDetail(UserDTO userDTO);


    void deleteUser(UserDTO userDTO);

}