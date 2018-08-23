package com.diaolizhi.simpleblog.controller;

import com.diaolizhi.simpleblog.domain.Comment;
import com.diaolizhi.simpleblog.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/8 13:18
 */

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    /**
     * 添加一条评论
     * @param article_id
     * @param speaker
     * @param comment_content
     * @return
     */
    @PostMapping("/add-one-comment")
    public String addOneComment(int article_id, String speaker,
                                String comment_content) {
        Comment comment = new Comment();
        comment.setArticle_id(article_id);
        comment.setSpeaker(speaker);
        comment.setComment_content(comment_content);
        comment.setComment_time(new Date());

        commentService.insertOneComment(comment);

        return "redirect:/article/id/" + article_id + "#comment";
    }

    /**
     * 删除一条评论
     * @param id
     * @param art_id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete")
    public String deleteComment(int id, int art_id) {

        commentService.deleteComById(id);

        return "redirect:/article/id/" + art_id + "#comment";
    }
}
