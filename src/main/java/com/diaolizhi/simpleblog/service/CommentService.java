package com.diaolizhi.simpleblog.service;

import com.diaolizhi.simpleblog.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    /**
     * 添加一条评论
     * @param comment
     */
    void insertOneComment(Comment comment);

    /**
     * 查询某篇文章下的评论
     * @param id
     * @return
     */
    List<Comment> selectCommentByArtId(int id);

    /**
     * 通过文章 id 删除该文章下的所有评论
     * @param id
     */
    void deleteComByArtId(int id);

    /**
     * 通过 id 删除评论
     * @param id
     */
    void deleteComById(int id);
}
