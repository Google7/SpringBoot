package test.demo.restful.mapper;

import java.util.List;

public interface UserMapper {
    List selectAll();

    List selectByUserId(int userId);

    boolean insertUser(String userName, String userPwd);

    boolean updateUser(String userName, int userId);

    boolean deleteUser(int userID);

    boolean demo(String userName, int userId);
}
