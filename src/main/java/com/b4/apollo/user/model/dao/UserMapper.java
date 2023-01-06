package com.b4.apollo.user.model.dao;

import com.b4.apollo.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    MemberDTO loginMember(MemberDTO m) throws Exception;

    int insertUser(UserDTO newUser);



//    MemberDTO updateMember(MemberDTO m) throws Exception;

    int idCheck(String userId);
//
//    void deleteMember(String userId);
}
