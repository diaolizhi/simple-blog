package com.diaolizhi.simpleblog.service;

import com.diaolizhi.simpleblog.domain.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlz
 * @time 2018年8月
 * @version v1.0
 */
@Service
public interface MessageService {

    /**
     * 添加一条留言
     * @param message
     */
    void insertOneMessage(Message message);

    /**
     * 查询所有留言
     * @return
     */
    List<Message> selectAllMessage();

    /**
     * 通过 id 删除留言
     * @param id
     */
    void deleteMessageById(int id);
}
