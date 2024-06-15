package com.example.papyrus.service;

import com.example.papyrus.dto.DiaryDTO;
import com.example.papyrus.mapper.DiaryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {
    private DiaryMapper diaryMapper;

    public DiaryServiceImpl(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public List<DiaryDTO> getDiaryList() {
        return diaryMapper.getDiaryList();
    }

    @Override
    public DiaryDTO getDiaryId(long diary_id) {
        return diaryMapper.getDiaryById(diary_id);
    }
}
