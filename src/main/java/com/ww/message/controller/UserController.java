package com.ww.message.controller;

import com.ww.message.pojo.Result;
import com.ww.message.pojo.ResultGenerator;
import com.ww.message.pojo.User;
import com.ww.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            return ResultGenerator.genFailResult("该用户名已被注册");
        }
        userService.addUser(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        User loginUser = userService.getUserByUsername(user.getUsername());
        if (loginUser == null) {
            return  ResultGenerator.genFailResult("用户名不存在");
        }
        if(!loginUser.getPassword().equals(user.getPassword())) {
            return ResultGenerator.genFailResult("密码错误");
        }
        session.setAttribute("userId", loginUser.getId());
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/logout")
    public Result logout(HttpSession session) {
        session.removeAttribute("userId");
        return ResultGenerator.genSuccessResult();
    }
}
