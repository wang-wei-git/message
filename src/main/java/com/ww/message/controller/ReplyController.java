package com.ww.message.controller;


import com.ww.message.pojo.Reply;
import com.ww.message.pojo.Result;
import com.ww.message.pojo.ResultGenerator;
import com.ww.message.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/add")
    public Result addReply(@RequestBody Reply reply, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        reply.setUserId(userId);
        reply.setCreateTime(new Date());
        replyService.addReply(reply);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/listByMessageId/{messageId}")
    public Result getReplyListByMessageId(@PathVariable Integer messageId) {
        List<Reply> replyList = replyService.getReplyListByMessageId(messageId);
        return ResultGenerator.genSuccessResult(replyList);
    }

}
