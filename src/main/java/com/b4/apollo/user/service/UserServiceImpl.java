package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.qna.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


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
    public void insertUser(UserDTO m){
        int result = userMapper.insertUser(m);

        if(result <= 0 ){
            throw new CommonException("회원 등록 실패");
        }
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

    public int idCheck(String userId) {
        int result = userMapper.idCheck(userId);
        if(result < 0 ) {
            throw new CommonException("아이디체크에 실패하였습니다.");
        }
        return result;
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



