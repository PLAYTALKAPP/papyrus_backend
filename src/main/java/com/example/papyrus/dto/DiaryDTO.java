package com.example.papyrus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDTO {
    private Long diary_id;
    private String user_id;
    private String diary_title;
    private String diary_content;
    private long diary_img_id;
    private Date diary_date;
    private Date write_date;
    private long category_id;

}
