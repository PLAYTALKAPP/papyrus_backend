package com.example.papyrus.controller;

import com.example.papyrus.dto.DiaryDTO;
import com.example.papyrus.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api")
@Controller
public class DiaryController {
    private DiaryService diaryService;


    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/diary")
    public ResponseEntity<List<DiaryDTO>> getDiaryList(){
        List<DiaryDTO> diarys = diaryService.getDiaryList();
        return ResponseEntity.ok(diarys);
    }

    @GetMapping("/diary/{diary_id}")
    public ResponseEntity<DiaryDTO> getDiaryId(@PathVariable("diary_id") Long diary_id){
        DiaryDTO diary = diaryService.getDiaryId(diary_id);
        return ResponseEntity.ok(diary);
    }

}
