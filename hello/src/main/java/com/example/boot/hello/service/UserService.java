package com.example.boot.hello.service;

import com.example.boot.hello.bean.UserInfo;
import java.util.List;

public interface UserService {

    boolean addUser(UserInfo userInfo);

    boolean updateUser(UserInfo userInfo);

    boolean deleteUser(int userId);

    UserInfo findUserByName(String userName);

    List<UserInfo> findAll();

}
