package com.example.papyrus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private String user_id;
  private String user_name;
  private String user_pw;
  private String phone;
  private String email;
  private String profile_img;
  private String status;
  private Date signup_date;
}
