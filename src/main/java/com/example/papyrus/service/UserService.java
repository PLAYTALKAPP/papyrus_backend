package com.example.papyrus.service;

import com.example.papyrus.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
  List<UserDTO> getUserList();
  int addUser(UserDTO userDTO);
  int userIdCheck(String userId);
  UserDTO loginUser(String userId, String userPw);
  UserDTO findUserById(String userId);
}
