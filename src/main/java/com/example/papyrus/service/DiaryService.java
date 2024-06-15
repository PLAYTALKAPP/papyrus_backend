package com.example.papyrus.service;

import com.example.papyrus.dto.DiaryDTO;

import java.util.List;

public interface DiaryService {
    List<DiaryDTO> getDiaryList();
    DiaryDTO getDiaryId(long diary_id);
}
