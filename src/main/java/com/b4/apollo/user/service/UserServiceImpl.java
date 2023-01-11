package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){this.userMapper = userMapper;}


    @Override
    public List<UserDTO> findAllUser() {
        return userMapper.findAllUser();
    }


//    @Override
//    public MemberDTO loginMember(MemberDTO m) throws Exception {
//        MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
//        System.out.println("loginUser : " + loginUser);
//
//        if (loginUser == null) {
//            throw new Exception("loginUser확인");
//        }
//        return loginUser;
//    }

    @Override
    public boolean insertUser(UserDTO newUser) throws Exception{
        int result = userMapper.insertUser(newUser);
        if(result <= 0) {
            throw new Exception("회원 등록 실패");
        }
        return result>0 ? true:  false;
    }

    @Override
    public boolean updateUser(UserDTO updateUTO) throws Exception{
        int result = userMapper.updateUser(updateUTO);
        if(result<=0){
             throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    }

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


}



