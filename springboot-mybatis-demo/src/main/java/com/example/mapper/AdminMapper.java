package com.example.mapper;


import com.example.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //应用程序在运行时，会自动为该接口创建一个实现类对象（代理对象），自动将该对象放进IOC容器中。
public interface AdminMapper {

    // 查询所有管理员
    List<Admin> findAll();

    // 根据用户名查询管理员
    @Select("select * from admin where name = #{name}")
    List<Admin> findByName(String name);

    // 根据id删除管理员
    @Delete("delete from admin where id = #{id}") //  #{id}是占位符，运行时会替换成？，之后会替换成参数值。
    int deleteById(Integer id);

    // 添加管理员
    @Insert("insert into admin(username, password, name, phone, email) values(#{username}, #{password}, #{name}, #{phone}, #{email})")
    void insert(Admin admin);

    // 根据id修改管理员
    @Update("update admin set username = #{username}, password = #{password}, name = #{name}, phone = #{phone}, email = #{email} where id = #{id}")
    void updateById(Admin admin);
}
