package com.b4.apollo.user.service;


import com.b4.apollo.user.model.dao.UserMapper;
import com.b4.apollo.user.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserDTO newUser) throws Exception{
        int result = userMapper.insertUser(newUser);
        System.out.println("회원가입페이지" +newUser);
        if(result <= 0) {
            throw new Exception("회원 등록 실패");
        }
        return result>0 ? true:  false;
    }


    @Override
    public boolean loginUser(UserDTO userDTO, HttpSession session) {
        UserDTO loginUser = userMapper.loginUser(userDTO.getUsername());
        boolean result = false;
        if(loginUser != null /*&& bCryptPasswordEncoder.matches(userDTO.getPassword(), loginUser.getPassword())*/){
            session.setAttribute("loginUser", loginUser);
            result = true;
        }
        return result;
    }

//    @Override
//    public UserDTO loginUser(String username) {
//        UserDTO loginUser = userMapper.loginUser(UserDTO.getUsername())
//    }

    @Override
    public UserDTO userDetail(UserDTO userDTO) {
        return userMapper.userDetail(userDTO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        userMapper.deleteUser(userDTO);
    }


//    @Transactional
//    public void joinUser(UserDTO userDto){
//        String inputPwd = userDto.getPassword();
//        String encodePwd= bCryptPasswordEncoder.encode(inputPwd);
//        userDto.setPassword(encodePwd);
//
////        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        userDto.setUserRole("ROLE_USER");
//
//        userDto = new UserDTO();
//        System.out.println(userDto);
//        userMapper.insertUser(userDto);
//    }

//    @Override
//    public UserDTO loginUser(UserDTO userDTO, HttpSession session) {
//        UserDTO loginUser = userMapper.loginUser(userDTO.getUsername());
//    }

//    @Override
//    public UserDTO loadUserByUsername(String username, String password) throws UsernameNotFoundException {
//        UserDTO userDTO = userMapper.loginUser(username, password);
//        if(userDTO==null){
//            throw new UsernameNotFoundException("사용자가 아님");
//        }
//        return userDTO;
//    }

}




