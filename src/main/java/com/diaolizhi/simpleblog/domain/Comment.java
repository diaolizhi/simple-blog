package com.diaolizhi.simpleblog.domain;

import java.util.Date;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/18 12:08
 */


public class Comment {

    private int id;
    private int article_id;
    private String speaker;
    private String comment_content;
    private Date comment_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
}
