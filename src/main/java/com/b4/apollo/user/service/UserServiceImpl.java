package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserDTO newUser) throws Exception{
        int result = userMapper.insertUser(newUser);
        System.out.println("회원가입페이지" +newUser);
        if(result <= 0) {
            throw new Exception("회원 등록 실패");
        }
        return result>0 ? true:  false;
    }


    @Override
    public boolean loginUser(UserDTO userDTO, HttpSession session) {
        UserDTO loginUser = userMapper.loginUser(userDTO.getUserId(), userDTO.getPassword());
        boolean result = false;
        if(loginUser != null){
            session.setAttribute("loginUser", loginUser);
            result = true;
        }
        return result;
    }


    @Override
    public UserDTO userDetail(UserDTO userDTO) {
        return userMapper.userDetail(userDTO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        userMapper.deleteUser(userDTO);
    }



}




