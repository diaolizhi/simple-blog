package com.diaolizhi.simpleblog.service.impl;

import com.diaolizhi.simpleblog.domain.Comment;
import com.diaolizhi.simpleblog.mapper.CommentMapper;
import com.diaolizhi.simpleblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/18 12:13
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Override
    public void insertOneComment(Comment comment) {
        mapper.insertOneComment(comment);
    }

    @Override
    public List<Comment> selectCommentByArtId(int id) {
        return mapper.selectCommentByArtId(id);
    }

    @Override
    public void deleteComByArtId(int id) {
        mapper.deleteComByArtId(id);
    }

    @Override
    public void deleteComById(int id) {
        mapper.deleteComById(id);
    }
}
