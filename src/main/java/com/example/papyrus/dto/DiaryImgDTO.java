package com.example.papyrus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryImgDTO {
    private long diary_img_id;
    private long diary_id;
    private String diary_src;
}
