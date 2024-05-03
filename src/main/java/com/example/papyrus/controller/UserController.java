package com.example.papyrus.controller;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/get/user")
  public ResponseEntity getUserList() {
    System.out.println(userService.getUserList());
    List<UserDTO> users = userService.getUserList();
    return ResponseEntity.ok(users);
  }
}
