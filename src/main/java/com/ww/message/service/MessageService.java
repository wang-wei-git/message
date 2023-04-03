package com.ww.message.service;

import com.ww.message.mapper.MessageMapper;
import com.ww.message.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    public List<Message> getMessageList() {
        return messageMapper.getMessageList();
    }

    public List<Message> getMessageListByUserId(Integer userId) {
        return messageMapper.getMessageListByUserId(userId);
    }

    public int deleteMessageByIdAndUserId(Integer id, Integer userId) {
        return messageMapper.deleteMessageByIdAndUserId(id, userId);
    }
}
