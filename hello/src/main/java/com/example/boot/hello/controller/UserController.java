package com.example.boot.hello.controller;

import com.example.boot.hello.bean.UserInfo;
import com.example.boot.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser( UserInfo userInfo) {
        System.out.println("开始新增...");
        return userService.addUser(userInfo);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser( UserInfo userInfo) {
        System.out.println("开始更新...");
        return userService.updateUser(userInfo);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "userName") int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserInfo findByUserName(@RequestParam(value = "userName") String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }


    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<UserInfo> findByUserAge() {
        System.out.println("开始查询所有数据...");
        return userService.findAll();
    }

}
