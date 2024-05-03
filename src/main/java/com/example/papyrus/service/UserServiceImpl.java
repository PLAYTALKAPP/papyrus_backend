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
}
