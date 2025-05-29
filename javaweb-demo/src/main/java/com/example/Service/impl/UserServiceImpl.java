package com.example.Service.impl;

import com.example.Dao.UserDao;
import com.example.Dao.impl.UserDaoImpl;
import com.example.Service.UserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Component //将类交给IOC容器管理
@Service
public class UserServiceImpl implements UserService {
    //了解依赖注入的三种方式
    //调用Dao方式一：以属性注入的方式
//    @Autowired //程序运行时，自动查询该类型的bean，并注入给该成员变量
//    private UserDao userDao ;
    //调用Dao方式二：以构造函数注入的方式
//    private final UserDao userDao;//以构造器的方式注入依赖时，对象应当使用final修饰
//    @Autowired//若构造函数只有一个时，可省略@Autowired注解
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
    //调用Dao方式三：以setter注入的方式
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getUsers() {
        //调用Dao层，获取用户信息
        List<String> list = userDao.getUser();

        //解析用户信息，封装为User对象:list集合
        List<User> users = list.stream().map(line -> {
            String[] split = line.split(",");//以逗号分隔，拆分字符串，返回一个字符串数组
            Integer  id = Integer.parseInt(split[0]);//第0个元素转化为整数赋值给id
            String username = split[1];//第1个元素为username
            String password = split[2];//第2个元素为password
            String name = split[3];//第3个元素为name
            Integer age = Integer.parseInt(split[4]);//第4个元素为age
            LocalDateTime updateTime = LocalDateTime.parse(split[5],  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));//将数组第五个元素按格式"yyyy-MM-dd HH:mm:ss"解析为LocalDateTime对象
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        return users;
    }
}
