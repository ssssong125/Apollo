package com.b4.apollo.user.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String userId;
    private String userPwd;
    private String userTel;
    private String userEmail;
    private String userAddr;
    private String userRole;
    private String userActive;
    private String userEntdate;
    private int point;
}
