package com.diaolizhi.simpleblog.service.impl;

import com.diaolizhi.simpleblog.domain.Message;
import com.diaolizhi.simpleblog.mapper.MessageMapper;
import com.diaolizhi.simpleblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/18 13:58
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;

    @Override
    public void insertOneMessage(Message message) {
        mapper.insertOneMessage(message);
    }

    @Override
    public List<Message> selectAllMessage() {
        return mapper.selectAllMessage();
    }

    @Override
    public void deleteMessageById(int id) {
        mapper.deleteMessageById(id);
    }
}
