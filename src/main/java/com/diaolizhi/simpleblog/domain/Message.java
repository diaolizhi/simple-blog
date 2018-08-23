package com.diaolizhi.simpleblog.domain;

import java.util.Date;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/18 13:13
 */
public class Message {

    private int id;
    private String speaker;
    private String message_content;
    private Date message_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Date getMessage_time() {
        return message_time;
    }

    public void setMessage_time(Date message_time) {
        this.message_time = message_time;
    }
}
