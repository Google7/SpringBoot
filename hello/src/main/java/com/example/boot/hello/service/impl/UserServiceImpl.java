package com.example.boot.hello.service.impl;

import com.example.boot.hello.bean.UserInfo;
import com.example.boot.hello.dao.UserDao;
import com.example.boot.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addUser(UserInfo userInfo) {
        boolean flag = false;
        try {
            userDao.addUser(userInfo);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(UserInfo userInfo) {
        boolean flag = false;
        try {
            userDao.updateUser(userInfo);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            userDao.deleteUser(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public UserInfo findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

}
