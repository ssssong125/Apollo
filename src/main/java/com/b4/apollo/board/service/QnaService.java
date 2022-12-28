package com.b4.apollo.board.service;

import com.b4.apollo.board.model.dto.Question;

import java.util.List;

public interface QnaService {
    public List<Question> findAll();
}
