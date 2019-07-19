package com.diaolizhi.simpleblog.mapper;

import com.diaolizhi.simpleblog.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 11:04
 */
public interface ArticleMapper {

    /**
     * 添加一篇文章
     * @param article
     * @return
     */
    @Insert("INSERT INTO article(title, author, category, created_time, modified_time, body) VALUES(#{title}, #{author}, #{category}, #{created_time}, #{modified_time}, #{body})")
    int createArticle(Article article);

    /**
     * 获取某一部分文章（使用分页插件之后就没用了）
     * @param begin_page
     * @param end_page
     * @return
     */
    @Select("SELECT id, title, author, created_time, category, is_hide, LEFT(body, 100) body FROM article ORDER BY created_time DESC LIMIT 0,10")
    List<Article> selectOnePage(int begin_page, int end_page);

    /**
     * 查询所有文章
     * @return
     */
    @Select("SELECT id, title, author, created_time, category, is_hide, body FROM article ORDER BY created_time")
    List<Article> selectAll();

    /**
     * 通过分类名称查找文章集合
     * @param category_name
     * @return
     */
    @Select("SELECT article.id, title FROM article JOIN category ON article.category = category.id AND category.category_name = #{category_name} ORDER BY created_time DESC")
    List<Article> selectArticleByCat(String category_name);

    /**
     * 通过 id 查找文章
     * @param id
     * @return
     */
    @Select("SELECT * FROM article WHERE id = #{id}")
    Article selectArticleById(int id);

    /**
     * 文章阅读量 +1
     * @param id
     */
    @Select("UPDATE article SET views = views + 1 WHERE id = #{id}")
    void addOneViews(int id);

    /**
     * 通过关键字匹配文章
     * @param keyWord
     * @return
     */
    @Select("SELECT * FROM article WHERE title LIKE #{keyWord} OR category LIKE #{keyWord} OR body LIKE #{keyWord}")
    List<Article> selectArticleByKeyWord(String keyWord);

    /**
     * 修改文章之后，更新内容及修改时间
     * @param article
     */
    @Update("UPDATE article SET title = #{title}, author = #{author}, category = #{category}, modified_time = #{modified_time}, body = #{body} WHERE id = #{id}")
    void updatearticleById(Article article);

    /**
     * 通过文章 id 查找目录 id
     * @param id
     * @return
     */
    @Select("SELECT category FROM article WHERE id = #{id}")
    int selectCatIdById(int id);

    /**
     * 通过 id 删除文章
     * @param id
     */
    @Delete("DELETE FROM article WHERE id = #{id}")
    void deleteArticleById(int id);
}
