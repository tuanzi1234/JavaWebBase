package com.example.Dao.impl;

import cn.hutool.core.io.IoUtil;
import com.example.Dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@Component //将类交给IOC容器管理
@Repository //使用对应IOC容器注解将类交给IOC容器管理,Service和Controller同理
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> getUser() {
        //加载资源文件：通过类加载器获取项目资源目录下"user.txt"文件的输入流。
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        //按行读取内容：使用工具类IoUtil将输入流按UTF-8编码逐行读取到ArrayList<String>集合，为后续将每行文本解析为User对象做准备。
        ArrayList<String> list = IoUtil.readLines(in , StandardCharsets.UTF_8,  new ArrayList<>());
        return list;
    }

}
