package com.b4.apollo.user.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDTO {
    private Integer userNo;
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
