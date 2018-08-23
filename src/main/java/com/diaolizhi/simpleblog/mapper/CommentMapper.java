package com.diaolizhi.simpleblog.mapper;

import com.diaolizhi.simpleblog.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dlz
 * @time 2018年8月
 * @version v1.0
 */
public interface CommentMapper {

    /**
     * 添加一条评论
     * @param comment
     */
    @Insert("INSERT INTO comments(article_id, speaker, comment_content, comment_time) VALUES (#{article_id}, #{speaker}, #{comment_content}, #{comment_time})")
    void insertOneComment(Comment comment);

    /**
     * 通过文章 id 查找该文章下的评论
     * @param id
     * @return
     */
    @Select("SELECT * FROM comments WHERE article_id = #{id} ORDER BY comment_time DESC")
    List<Comment> selectCommentByArtId(int id);

    /**
     * 通过文章 id 删除文章下的评论
     * @param id
     */
    @Delete("DELETE FROM comments WHERE article_id = #{article_id}")
    void deleteComByArtId(int id);

    /**
     * 通过 id 删除评论
     * @param id
     */
    @Delete("DELETE FROM comments WHERE id = #{id}")
    void deleteComById(int id);
}
