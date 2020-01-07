package com.example.euserprovider;

import com.example.emodeldao.user.po.User;
import com.example.euserprovider.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/7 0007 10:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void findById(){
        User user = userDao.findById(1);
        System.out.println(user.getUserName());
        System.out.println(user.getUserNickName());
        System.out.println(user.getUserPwd());
    }
}
