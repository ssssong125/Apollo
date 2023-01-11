package com.b4.apollo.user.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDTO {
    private Integer userNo;
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
