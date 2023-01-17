package com.b4.apollo.qna.service;

import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.exception.DataNotFoundException;
import com.b4.apollo.qna.model.dao.BoardMapper;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.b4.apollo.user.model.dto.UserDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private UserDTO userDTO;


    @Override
    public void deleteBoard(int boardNo) {
        int result = boardMapper.deleteBoard(boardNo);

        if(result < 0) {
            throw new CommonException("게시글삭제실패 ");
        }
    }

//    @Override
//    public void insertBoard(String usrId, String boardTitle, String boardContent) {
//
//    }



//    @Override
//    public void insertBoard(HttpSession session, String userId, String boardTitle, String boardContent) {
//        String writer = (String) session.getAttribute("userId");
//        QuestionDTO q = new QuestionDTO();
//        q.setUserId(writer);
//        q.setBoardTitle(boardTitle);
//        q.setBoardContent(boardContent);
//        q.setCreateDate(LocalDateTime.now());
//        int result = boardMapper.insertBoard(q);
//
//        if(result < 0) {
//            throw new CommonException("게시글 추가 실패 ");
//        }
//    }

    @Override
    public void updateBoard(QuestionDTO q, String boardTitle, String boardContent) {
        q.setBoardTitle(boardTitle);
        q.setBoardContent(boardContent);
        q.setCreateDate(LocalDateTime.now());
        int result = boardMapper.updateBoard(q);

        if(result < 0) {
            throw new CommonException("게시글 수정 실패 ");
        }
    }

    @Override
    public Page<QuestionDTO> selectList(int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return boardMapper.selectList();
    }

    @Override
    public void insertBoard(String writer, String boardTitle, String boardContent) {

//        System.out.println("writer = " + writer);
        QuestionDTO q = new QuestionDTO();
        q.setUserId(writer);
        q.setBoardTitle(boardTitle);
        q.setBoardContent(boardContent);
        q.setCreateDate(LocalDateTime.now());
        int result = boardMapper.insertBoard(q);

        if (result < 0) {
            throw new CommonException("게시글 추가 실패 ");
        }
    }

    @Override
        public QuestionDTO selectBoard (int bno){

            boardMapper.updateCount(bno);

            Optional<QuestionDTO> question = Optional.ofNullable((QuestionDTO) this.boardMapper.selectBoard(bno));

            if (question.isPresent()) {
                return question.get();
            } else {
                throw new DataNotFoundException("question not found");
            }
        }

   }

