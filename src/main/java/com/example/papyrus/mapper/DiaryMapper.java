package com.example.papyrus.mapper;

import com.example.papyrus.dto.DiaryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    List<DiaryDTO> getDiaryList();
    DiaryDTO getDiaryById(long id);
}
