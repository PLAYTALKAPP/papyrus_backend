package com.example.papyrus.controller;

import com.example.papyrus.dto.UserDTO;
import com.example.papyrus.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/api")
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> requestBody) {
        String user_id = requestBody.get("user_id");
        String user_pw = requestBody.get("user_pw");
        UserDTO result = userService.loginUser(user_id, user_pw);

        if (result != null) {
            session.setAttribute("user_id", user_id);
            session.setAttribute("user_pw", user_pw);
            session.setAttribute("user_name", result.getUser_name());
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(500).body("User could not be found");
        }
    }

    @GetMapping("/userInfo")
    public ResponseEntity<UserDTO> getUserInfo() {
        String userId = (String) session.getAttribute("user_id");
        if (userId != null) {
            UserDTO user = userService.findUserById(userId);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}
