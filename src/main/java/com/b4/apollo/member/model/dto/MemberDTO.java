package com.b4.apollo.member.model.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private String userId;
    private String userPwd;
    private String userName;
    private String userTel;
    private String userAddr;
    private String userEmail;
    private char userRole;
    private char userActive;
    private Date userEntdate;
    private int userPoint;


}
