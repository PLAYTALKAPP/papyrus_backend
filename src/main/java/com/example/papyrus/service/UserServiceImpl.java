package com.example.papyrus.service;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserMapper userMapper;

  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public List<UserDTO> getUserList() {
    return userMapper.getUserList();
  }


  @Override
  public int addUser(UserDTO user) {
    int addUser = userMapper.signUpUser(user);
    return addUser;
  }

  @Override
  public int userIdCheck(String userId) {
    int result = userMapper.userIdCheck(userId);
    return result;
  }

  @Override
  public UserDTO loginUser(String userId, String userPw) {
    UserDTO loginUser = userMapper.loginUser(userId, userPw);
    return loginUser;
  }
}
