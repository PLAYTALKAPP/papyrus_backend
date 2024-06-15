package com.example.papyrus.mapper;

import com.example.papyrus.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  List<UserDTO> getUserList();
  int signUpUser(UserDTO user);
  int userIdCheck(String user_id);
  UserDTO loginUser(String user_id, String user_pw);
}
