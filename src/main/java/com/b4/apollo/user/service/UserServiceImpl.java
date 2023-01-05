package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){this.userMapper = userMapper;}


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
    public boolean insertUser(UserDTO newUser){
        int result = userMapper.insertUser(newUser);

        return result>0 ? true:  false;
    }

//    @Override
//    public MemberDTO updateMember(MemberDTO m) throws Exception {
//        int result = memberDAO.updateMember(sqlSession, m);
//
//        if (result < 0) {
//            MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
//            return loginUser;
//        } else {
//            throw new Exception("회원수정실패");
//        }
//    }

    @Override
    public int idCheck(String userId) {
        int cnt = userMapper.idCheck(userId);
        System.out.println("cnt: " + cnt);
        return cnt;
    }

//    @Override
//    public void deleteMember(String userId) {
//            int result = memberDAO.deleteMember(sqlSession, userId);
//
//            if (result < 0) {
//                throw new CommonException("회원탈퇴실패");
//            }
//        }
    }



