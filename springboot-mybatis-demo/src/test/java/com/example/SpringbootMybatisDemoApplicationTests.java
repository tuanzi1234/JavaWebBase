package com.example;

import com.example.mapper.AdminMapper;
import com.example.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //SpringBoot测试注解，当测试类中的测试方法运行时，会自动加载SpringBoot应用。
class SpringbootMybatisDemoApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    //  测试查询所有管理员的方法
    @Test
    void findAllTest() {
        List<Admin> admins = adminMapper.findAll();
        admins.forEach(System.out::println);

    }

    //  测试删除指定id的管理员的方法
    @Test
    void deleteByIdTest() {
        int i = adminMapper.deleteById(29);
        System.out.println(i);
    }

    //  测试添加管理员的方法
    @Test
    void insertTest() {
        Admin admin = new Admin( null, "admin", "admin", "admin", "admin", "admin", "admin");
        adminMapper.insert(admin);
    }

    //  测试修改管理员的方法
    @Test
    void updateByIdTest() {
        Admin admin = new Admin( 29, "admin0001", "admin0001", "admin0001", "admin", "admin", "admin");
        adminMapper.updateById(admin);
    }
    //  测试根据用户名查询管理员的方法
    @Test
    void findByUsernameTest() {
        List<Admin> admin = adminMapper.findByName("admin");
        admin.forEach(System.out::println);
    }


}
