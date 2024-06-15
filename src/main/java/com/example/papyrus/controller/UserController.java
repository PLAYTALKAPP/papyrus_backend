package com.example.papyrus.controller;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;
@RequestMapping("/api")
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public ResponseEntity getUserList() {
    List<UserDTO> users = userService.getUserList();
    return ResponseEntity.ok(users);
  }

  @PostMapping("/addUser")
  public ResponseEntity<?> signUpUser(@RequestBody UserDTO userDTO) {
    int result = userService.addUser(userDTO);
    if (result > 0) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(500).body("User could not be added");
    }
  }

  @PostMapping("/checkUser")
  public ResponseEntity<?> userIdCheck(@RequestBody Map<String, String> requestBody) {
      String user_id = requestBody.get("user_id");
      int result = userService.userIdCheck(user_id);
      if (result > 0) {
        return ResponseEntity.status(500).body("User could not find User");
      } else {
        return ResponseEntity.ok().build();
      }
  }


}



