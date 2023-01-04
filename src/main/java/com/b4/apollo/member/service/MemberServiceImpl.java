package com.b4.apollo.member.service;

import com.b4.apollo.member.model.dao.MemberDAO;
import com.b4.apollo.member.model.dto.MemberDTO;
import com.b4.apollo.qna.exception.CommonException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public MemberDTO loginMember(MemberDTO m) throws Exception {
        MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
        System.out.println("loginUser : " + loginUser);

        if (loginUser == null) {
            throw new Exception("loginUser확인");
        }
        return loginUser;
    }

    @Override
    public void insertMember(MemberDTO m) {

        int result = memberDAO.insertMember(sqlSession, m);


        if (result <= 0) {

            throw new CommonException("회원가입에 실패 하였습니다.");

        }

    @Override
    public MemberDTO updateMember (MemberDTO m) throws Exception {
        int result = memberDAO.updateMember(sqlSession, m);

        if (result < 0) {
            MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
            return loginUser;
        } else {
            throw new Exception("회원수정실패");
        }
    }

    @Override
    public int idCheck (String userId){
        int result = memberDAO.idCheck(sqlSession, userId);
        if (result < 0) {
            throw new CommonException("아이디를 다시 체크해주세요");
        }
        return result;
    }

    @Override
    public void deleteMember (String userId){
        int result = memberDAO.deleteMember(sqlSession, userId);

        if (result < 0) {
            throw new CommonException("회원탈퇴실패");
        }
    }

}

