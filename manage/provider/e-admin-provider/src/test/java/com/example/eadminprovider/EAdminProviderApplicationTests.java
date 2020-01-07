package com.example.eadminprovider;


import com.example.eadminprovider.dao.AdminDao;
import com.example.emodeldao.admin.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EAdminProviderApplicationTests {

    @Resource
    public AdminDao adminDao;

    @Test
    public void find(){
        Admin admin = new Admin();
        admin.setId(1);
        Admin admin1 = adminDao.findById(admin);
        System.out.println(admin1.getAdminName());
        System.out.println(admin1.getAdminPwd());
    }
}
