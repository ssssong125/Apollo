package com.b4.apollo.user.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private String userPwd;
    private String userName;
    private String userTel;
    private String userAddr;
    private String userEmail;
    private String userRole;
    private String userActive;
    private String userEntdate;
    private int point;
}
