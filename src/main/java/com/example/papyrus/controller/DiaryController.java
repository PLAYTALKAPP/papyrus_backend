package com.example.papyrus.controller;

import com.example.papyrus.dto.DiaryDTO;
import com.example.papyrus.dto.DiaryImgDTO;
import com.example.papyrus.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api")
@Controller
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/diary")
    public ResponseEntity<List<DiaryDTO>> getDiaryList(){
        List<DiaryDTO> diarys = diaryService.getDiaryList();
        return ResponseEntity.ok(diarys);
    }

    @GetMapping("/diary/user/{user_id}")
    public ResponseEntity<List<DiaryDTO>> getUserDiaryList(@PathVariable("user_id") String user_id){
        List<DiaryDTO> diarys = diaryService.getUserDiaryList(user_id);
        return ResponseEntity.ok(diarys);
    }

    @GetMapping("/diary/{diary_id}")
    public ResponseEntity<DiaryDTO> getDiaryId(@PathVariable("diary_id") Long diary_id){
        DiaryDTO diary = diaryService.getDiaryId(diary_id);
        return ResponseEntity.ok(diary);
    }

    @PostMapping(value = "/addDiary",produces = "application/json", consumes = "multipart/form-data")
    public ResponseEntity<?> signUpUser(@RequestParam("user_id") String userId,
                                        @RequestParam("diary_title") String diaryTitle,
                                        @RequestParam("diary_content") String diaryContent,
                                        @RequestParam("category_id") long categoryId,
                                        @RequestParam(required = false, value = "diary_src") MultipartFile file) {
        try {
            // 파일을 저장하거나 처리하는 로직
            DiaryDTO diaryDTO = new DiaryDTO();
            DiaryImgDTO diaryImgDTO = new DiaryImgDTO();
            diaryDTO.setUser_id(userId);
            diaryDTO.setDiary_title(diaryTitle);
            diaryDTO.setDiary_content(diaryContent);
            diaryDTO.setCategory_id(categoryId);//타입변환을 해야할것 같음..

            if(file !=null){
                diaryImgDTO.setDiary_src(file.getOriginalFilename());
                //저장 메소드기입란
                diaryDTO.setDiary_img_id(diaryImgDTO.getDiary_img_id());
            }
            int result = diaryService.addDiary(diaryDTO);
            if (result > 0) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(500).body("Diary could not be added");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred");
        }
    }

}
