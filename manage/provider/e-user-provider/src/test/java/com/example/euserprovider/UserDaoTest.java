package com.example.euserprovider;

import com.example.emodeldao.user.po.User;
import com.example.euserprovider.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void insert(){
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setEmail("67515151@qq.com");
        user.setIDCard("1515615615156151");
        user.setRealName("离");
        user.setTel("18111216795");
        user.setType(1);
        user.setUserName("你好");
        user.setUserNickName("打卡机SD卡");
        user.setUserPwd("15615156");
        user.setUserQuestionEncrypted("你是谁？");
        user.setUserQuestionEncryptedAnswer("我是谁?");
        user.setCreationTime("2020-1-9 14:39");
        user.setDel(1);
        user.setModifyId("1");
        user.setModifyTime("2020-1-9 14:40");


        map.put("User",user);

        userDao.insert(map);
    }

    @Test
    public void update(){
        Map<String,Object> map = new HashMap<>();
        User user = new User();

        user.setEmail("67515151@qq.com");
        user.setIDCard("1515615615156151");
        user.setRealName("离");
        user.setTel("18111216795");
        user.setType(1);
        user.setUserName("你好");
        user.setUserNickName("打卡机SD卡a");
        user.setUserPwd("15615156");
        user.setUserQuestionEncrypted("你是谁？");
        user.setUserQuestionEncryptedAnswer("我是谁?");
        user.setCreationTime("2020-1-9 14:39");
        user.setDel(1);
        user.setModifyId("1");
        user.setModifyTime("2020-1-9 14:40");

        map.put("User",user);

        userDao.update(map);
    }

    @Test
    public void del(){
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setUserName("你好");
        user.setDel(0);


        map.put("User",user);

        userDao.del(map);
    }

}
