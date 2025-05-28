package com.example.controller;


import com.example.Service.UserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息请求
 */
@RestController//将controller的返回值作为响应体的数值直接响应，返回对象是从对象/集合转为JSON字符串，并响应给前端。
public class UserController {
    //声明Service
    //实现解耦操作
//    private UserService userService = new UserServiceImpl();
    //删除代码中new的对象，使用@Autowired注解注入，Service和Dao层的操作一样
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> getUser() throws Exception {
        //读取D:\idea\code\java web\JavaWebBase\javaweb-demo\src\main\resources\ user.txt下的user.txt文件
        //将文件路径写死了，不推荐
        //InputStream in = new FileInputStream(new File("D:\\idea\\code\\java web\\JavaWebBase\\javaweb-demo\\src\\main\\resources\\user.txt"));

        /*       获取数据，属于Dao层
        //加载资源文件：通过类加载器获取项目资源目录下"user.txt"文件的输入流。
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        //按行读取内容：使用工具类IoUtil将输入流按UTF-8编码逐行读取到ArrayList<String>集合，为后续将每行文本解析为User对象做准备。
        ArrayList<String> list = IoUtil.readLines(in , StandardCharsets.UTF_8,  new ArrayList<>());
         */

        /*       对用户数据进行逻辑处理，属于Service层
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
         */

        //返回用户信息
        //return users;

        //将上述代码拆分优化，实现分层解耦
        //调用Service层获取用户信息
        return userService.getUsers();
    }
}
