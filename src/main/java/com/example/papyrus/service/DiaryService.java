package com.example.papyrus.service;

import com.example.papyrus.dto.DiaryDTO;

import java.util.List;

public interface DiaryService {
    List<DiaryDTO> getDiaryList();
    List<DiaryDTO> getUserDiaryList(String user_id);
    DiaryDTO getDiaryId(long diary_id);
    int addDiary(DiaryDTO diaryDTO);
}
