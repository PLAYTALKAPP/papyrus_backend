package com.example.papyrus.mapper;

import com.example.papyrus.dto.DiaryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryDTO> getDiaryList();
    List<DiaryDTO> getUserDiaryList(String user_id);
    DiaryDTO getDiaryById(long id);
    int addDiary(DiaryDTO diary);
}
