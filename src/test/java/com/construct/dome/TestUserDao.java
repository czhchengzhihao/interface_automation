package com.construct.dome;

import com.construct.demo.UserDao;
import com.construct.model.User;
import com.construct.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class TestUserDao {
    @Test
    public void test() {
        //获取SqlSession对象
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        //执行sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


}
