package com.diaolizhi.simpleblog.service;

import com.diaolizhi.simpleblog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 11:15
 */

@Service
public interface ArticleService {

    /**
     * 添加一篇文章
     * @param article
     * @return
     */
    int createArticle(Article article);

    /**
     * 查询所有文章
     * @return
     */
    List<Article> selectAll();

    /**
     * 通过名字查找目录下的文章
     * @param category_name
     * @return
     */
    List<Article> selectArticleByCat(String category_name);

    /**
     * 通过 id 查找文章
     * @param id
     * @return
     */
    Article selectArticleById(int id);

    /**
     * 阅读量 +1
     * @param id
     */
    void addOneViews(int id);

    /**
     * 通过关键字查找文章
     * @param keyWord
     * @return
     */
    List<Article> selectArticleByKeyWord(String keyWord);

    /**
     * 更新文章
     * @param article
     */
    void updatearticleById(Article article);

    /**
     * 通过文章 id 查找目录 id
     * @param id
     * @return
     */
    int selectCatIdById(int id);

    /**
     * 通过 id 删除文章
     * @param id
     */
    void deleteArticleById(int id);
}
