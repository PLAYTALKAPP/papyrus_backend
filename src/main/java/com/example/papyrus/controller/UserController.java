package com.example.papyrus.controller;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.service.UserService;
import jakarta.mail.Multipart;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import java.util.List;
@RequestMapping("/api")
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public ResponseEntity<?> getUserList() {
    List<UserDTO> users = userService.getUserList();
    return ResponseEntity.ok(users);
  }

//  @PostMapping("/addUser")
  @PostMapping(value = "/addUser",produces = "application/json", consumes = "multipart/form-data")
  public ResponseEntity<?> signUpUser(@RequestParam("user_id") String userId,
                                      @RequestParam("user_name") String userName,
                                      @RequestParam("user_pw") String userPw,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("email") String email,
                                      @RequestParam(required = false, value = "profile_img") MultipartFile file) {
    try {
      // 파일을 저장하거나 처리하는 로직
      UserDTO userDTO = new UserDTO();
      userDTO.setUser_id(userId);
      userDTO.setUser_name(userName);
      userDTO.setUser_pw(userPw);
      userDTO.setPhone(phone);
      userDTO.setEmail(email);
      if(file !=null){
        userDTO.setProfile_img(file.getOriginalFilename());
      }
      int result = userService.addUser(userDTO);
      if (result > 0) {
        return ResponseEntity.ok().build();
      } else {
        return ResponseEntity.status(500).body("User could not be added");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("An error occurred");
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



