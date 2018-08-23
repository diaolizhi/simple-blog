package com.diaolizhi.simpleblog.mapper;

import com.diaolizhi.simpleblog.domain.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dlz
 * @time 2018年8月
 * @version v1.0
 */
public interface MessageMapper {

    /**
     * 添加一条留言
     * @param message
     */
    @Insert("INSERT INTO message(speaker, message_content, message_time) VALUES(#{speaker}, #{message_content}, #{message_time})")
    void insertOneMessage(Message message);

    /**
     * 查询所有留言
     * @return
     */
    @Select("SELECT * FROM message ORDER BY message_time DESC")
    List<Message> selectAllMessage();

    /**
     * 通过 id 删除留言
     * @param id
     */
    @Delete("DELETE FROM message WHERE id = #{id}")
    void deleteMessageById(int id);
}
