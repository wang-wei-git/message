package com.ww.message.controller;

import com.ww.message.pojo.Message;
import com.ww.message.pojo.Result;
import com.ww.message.pojo.ResultGenerator;
import com.ww.message.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public Result addMessage(@RequestBody Message message, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        message.setUserId(userId);
        message.setCreateTime(new Date());
        messageService.addMessage(message);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/list")
    public Result getMessageList() {
        List<Message> messageList = messageService.getMessageList();
        return ResultGenerator.genSuccessResult(messageList);
    }

    @GetMapping("/listByUser")
    public Result getMessageListByUser(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        List<Message> messageList = messageService.getMessageListByUserId(userId);
        return ResultGenerator.genSuccessResult(messageList);
    }

    @DeleteMapping("/{id}")
    public Result deleteMessage(@PathVariable Integer id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        int rows = messageService.deleteMessageByIdAndUserId(id, userId);
        if (rows == 0) {
            return ResultGenerator.genFailResult("删除失败");
        }
        return ResultGenerator.genSuccessResult();
    }

}
