package com.diaolizhi.simpleblog.domain;

import java.util.Date;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 10:47
 */

public class Article {
    private int id;
    private String title;
    private String author;
    private int category;
    private Date created_time;
    private Date modified_time;
    private int is_hide;
    private int views;
    private String body;
    /**
     * catName 并没有放进数据库
     */
    private String catName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public int getIs_hide() {
        return is_hide;
    }

    public void setIs_hide(int is_hide) {
        this.is_hide = is_hide;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", is_hide=" + is_hide +
                ", views=" + views +
                ", body='" + body + '\'' +
                '}';
    }
}
