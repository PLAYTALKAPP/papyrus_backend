package com.example.papyrus.mapper;

import com.example.papyrus.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  List<UserDTO> getUserList();
}
