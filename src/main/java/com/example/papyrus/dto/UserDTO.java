package com.example.papyrus.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
