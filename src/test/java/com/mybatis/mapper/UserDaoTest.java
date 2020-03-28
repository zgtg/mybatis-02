package com.mybatis.mapper;

import com.mybatis.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    /**
     * 获取所有用户
     */
    @Test
    public void testGetAll() {
        List<User> userList = new UserDao().getAll();

        System.out.println(((List) userList).size());
    }

    /**
     * 根据ID删除用户
     */
    @Test
    public void testDeleteById() {
        int num = new UserDao().deleteById(1);
        Assert.assertEquals(1, num);
    }
}
