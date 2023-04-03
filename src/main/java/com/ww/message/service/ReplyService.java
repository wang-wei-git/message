package com.ww.message.service;

import com.ww.message.mapper.ReplyMapper;
import com.ww.message.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    public List<Reply> getReplyListByMessageId(Integer messageId) {
        return replyMapper.getReplyListByMessageId(messageId);
    }
}