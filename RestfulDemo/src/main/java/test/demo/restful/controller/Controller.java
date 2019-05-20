package test.demo.restful.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import test.demo.restful.bean.Result;
import test.demo.restful.mapper.UserMapper;
import test.demo.restful.singleton.SingletonMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api") //在类上使用RequestMapping，里面设置的value就是方法的父路径
public class Controller {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        sqlSessionFactory = SingletonMybatis.getSqlSessionFactory();
    }

    @RequestMapping  //如果方法上的RequestMapping没有value，则此方法默认被父路径调用
    public String index() {
        return "hello spring boot";
    }

    //这里体现了restful风格的请求，按照请求的类型，来进行增删查改。
    //设计restful api（其实也就是URL），不要有冗余，例如不要写成getUsers，URL中
    //最好不要有动词。
    @RequestMapping(method = RequestMethod.GET, value = "/select")
    public Result selectAll(HttpServletResponse response) {
        List list;
        Result result = new Result();
        //获取一个连接
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            //得到映射器
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用接口中的方法去执行xml文件中的SQL语句
            list = userMapper.selectAll();
            //要提交后才会生效
            sqlSession.commit();
            //最后记得关闭连接
            sqlSession.close();
            result.setSuccess(true);
            result.setData(list);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/select/{userId}")
    public Result selectByUserId(HttpServletResponse response, @PathVariable int userId) {
        List list;
        Result result = new Result();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            list = userMapper.selectByUserId(userId);
            sqlSession.commit();
            sqlSession.close();
            result.setSuccess(true);
            result.setData(list);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public Result insertUser(HttpServletResponse response, @RequestParam String userName, @RequestParam String userPwd) {
        Result result = new Result();
        boolean success;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            success = userMapper.insertUser(userName, userPwd);
            sqlSession.commit();
            sqlSession.close();
            result.setSuccess(success);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Result updateUser(HttpServletResponse response, @RequestParam String userName, @RequestParam int userId) {
        Result result = new Result();
        boolean success;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            success = userMapper.updateUser(userName, userId);
            sqlSession.commit();
            sqlSession.close();
            result.setSuccess(success);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public Result deleteUser(HttpServletResponse response, @RequestParam int userId) {
        Result result = new Result();
        boolean success;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            success = userMapper.deleteUser(userId);
            sqlSession.commit();
            sqlSession.close();
            result.setSuccess(success);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/demo")
    public Result demo(HttpServletResponse response, @RequestParam String userName,@RequestParam int userId) {
        Result result = new Result();
        boolean success;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            success = userMapper.demo(userName,userId);
            sqlSession.commit();
            sqlSession.close();
            result.setSuccess(success);
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        return result;
    }

}
