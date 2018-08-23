package com.diaolizhi.simpleblog.domain;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 12:34
 */
public class category {

    private int id;
    private String category_name;
    private int article_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getArticle_num() {
        return article_num;
    }

    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }
}
