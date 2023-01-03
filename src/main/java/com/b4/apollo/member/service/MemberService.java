package com.b4.apollo.member.service;

import com.b4.apollo.member.model.dto.MemberDTO;

public interface MemberService {

    MemberDTO loginMember(MemberDTO m) throws Exception;

    void insertMember(MemberDTO m);

    MemberDTO updateMember(MemberDTO m) throws Exception;

    int idCheck(String userId);

    void deleteMember(String userId);

}
