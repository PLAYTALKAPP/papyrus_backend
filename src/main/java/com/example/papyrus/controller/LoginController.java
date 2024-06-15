package com.example.papyrus.controller;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RequestMapping("/api")
@Controller
public class LoginController {
    @Autowired
    private UserService userService;



    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(HttpServletRequest request, @RequestBody Map<String, String> requestBody) {
        String user_id = requestBody.get("user_id");
        String user_pw = requestBody.get("user_pw");
        UserDTO result = userService.loginUser(user_id,user_pw);
        if (result!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user_id);
//            session.setAttribute("user_pw", user_pw);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(500).body("User could not find User");
        }
    }
}
