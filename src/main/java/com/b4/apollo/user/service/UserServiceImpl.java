package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){this.userMapper = userMapper;}


//    @Override
//    public List<UserDTO> findAllUser() {
//        return userMapper.findAllUser();
//    }



    @Override
    public boolean insertUser(UserDTO newUser) throws Exception{
        int result = userMapper.insertUser(newUser);
        if(result <= 0) {
            throw new Exception("회원 등록 실패");
        }
        return result>0 ? true:  false;
    }

//    @Override
//    public boolean updateUser(UserDTO userDTO) throws Exception{
//        //updateUTO.
//        int result = userMapper.updateUser(userDTO);
//        if(result<=0){
//             throw new Exception("회원정보 수정 실패");
//        }
//        return result>0 ? true:  false;
//    }

//    @Override
//    public int idCheck(String userId) {
//        int cnt = userMapper.idCheck(userId);
//        System.out.println("cnt: " + cnt);
//        return cnt;
//    }

    @Override
    public void deleteUser(String userId) throws Exception{
            int result = userMapper.deleteUser(userId);
            if (result < 0) {
                throw new Exception("회원탈퇴실패");
            }
        }

    @Override
    public boolean loginUser(UserDTO userDTO, HttpSession session) {
        UserDTO loginUser = userMapper.loginUser(userDTO);
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

//    @Override
//    public UserDTO loginUser(UserDTO userDTO) {
//        userDTO = userMapper.loginUser(userDTO);
//
//        return userDTO;
//    }

//    @Override
//    public UserDTO showUserInfo(String userId) {
//        return userMapper.showUserInfo(userId);
//    }
//
//    @Override
//    public UserDTO findById(Long id) {
//        return null;
//    }

//    @Override
//    public Map<String, List<String>> getPermitListMap() {
//        return null;
//    }


}



