package com.b4.apollo.user.model.dto;

import lombok.*;

import java.sql.Date;

@Data
public class UserDTO {
    private String userName;
    private String userId;
    private String userTel;
    private String userPwd;
    private String userEmail;
    private String userAddr;
    private char userRole;
    private char userActive;
    private Date userEntdate;
    private int userPoint;

}
