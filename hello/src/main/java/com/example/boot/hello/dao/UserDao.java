package com.example.boot.hello.dao;

import com.example.boot.hello.bean.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 用户数据新增
     */
    @Insert("insert into userinfo(userId,userName,userAge) values (#{userId},#{userName},#{userAge})")
    void addUser(UserInfo userInfo);

    /**
     * 用户数据修改
     */
    @Update("update userinfo set userName=#{userName},userAge=#{userAge} where userId=#{userId}")
    void updateUser(UserInfo userInfo);

    /**
     * 用户数据删除
     */
    @Delete("delete from userinfo where userId=#{userId}")
    void deleteUser(int userId);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT * FROM userinfo where userName=#{userName}")
    UserInfo findByName(@Param("userName") String userName);

    /**
     * 查询所有
     */
    @Select("SELECT * FROM userinfo")
    List<UserInfo> findAll();

}
