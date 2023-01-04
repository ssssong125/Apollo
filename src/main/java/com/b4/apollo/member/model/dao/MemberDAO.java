package com.b4.apollo.member.model.dao;

import com.b4.apollo.member.model.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    public MemberDTO loginMember(SqlSessionTemplate sqlSession, MemberDTO m){
        MemberDTO m1 = sqlSession.selectOne("memberMapper.loginMember", m);
        return m1;
    }
    public int insertMember(SqlSessionTemplate sqlSession, MemberDTO m){
        return sqlSession.insert("memberMapper.insertMember", m);
    }

    public int updateMember(SqlSessionTemplate sqlSession, MemberDTO m){
        return sqlSession.update("memberMapper.updateMember", m);
    }

    public int idCheck(SqlSessionTemplate sqlSession, String userId){
        return sqlSession.selectOne("memberMapper.idCheck", userId);
    }

    public int deleteMember(SqlSessionTemplate sqlSession, String userId){
        return sqlSession.delete("memberMapper.deleteMember", userId);
    }
}
