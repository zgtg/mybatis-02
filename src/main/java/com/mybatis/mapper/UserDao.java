package com.mybatis.mapper;

import com.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserDao {
    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAll() {
        try {
            // 通过配置文件 生成SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> userList = sqlSession.selectList("com.mybatis.mapper.UserMapper.getAll");

            // 关闭资源
            sqlSession.close();

            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(int id) {
        try {
            // 通过配置文件 生成SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            int num = sqlSession.delete("com.mybatis.mapper.UserMapper.deleteById", 1);

            // 提交
            sqlSession.commit();
            // 关闭资源
            sqlSession.close();

            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
