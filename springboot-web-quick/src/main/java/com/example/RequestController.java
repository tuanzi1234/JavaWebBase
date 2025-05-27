package com.example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    //获取请求参数
    @RequestMapping("/getParam")
    public String getParam(HttpServletRequest request) {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式：" + method);
        //2.获取请求url
        String url = request.getRequestURL().toString();
        System.out.println("请求url：" + url);
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议：" + protocol);
        //4.获取请求头
        String header = request.getHeader("User-Agent");
        System.out.println("请求头：" + header);
        //5.获取请求参数
        String param = request.getParameter("username");
        String value = request.getParameter("age");
        System.out.println("请求参数：" + "\t\n" + "用户名：" + param + "\t\n" + "年龄：" + value);
        return "请求参数获取成功！";
    }
}
