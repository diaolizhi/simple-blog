package com.diaolizhi.simpleblog.service.impl;

import com.diaolizhi.simpleblog.domain.Article;
import com.diaolizhi.simpleblog.mapper.ArticleMapper;
import com.diaolizhi.simpleblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 11:16
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper mapper;

    @Override
    public int createArticle(Article article) {
        return mapper.createArticle(article);
    }

    @Override
    public List<Article> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Article> selectArticleByCat(String category_name) {
        return mapper.selectArticleByCat(category_name);
    }

    @Override
    public Article selectArticleById(int id) {
        return mapper.selectArticleById(id);
    }

    @Override
    public void addOneViews(int id) {
        mapper.addOneViews(id);
    }

    @Override
    public List<Article> selectArticleByKeyWord(String keyWord) {
        return mapper.selectArticleByKeyWord(keyWord);
    }

    @Override
    public void updatearticleById(Article article) {
        mapper.updatearticleById(article);
    }

    @Override
    public int selectCatIdById(int id) {
        return mapper.selectCatIdById(id);
    }

    @Override
    public void deleteArticleById(int id) {
        mapper.deleteArticleById(id);
    }
}
