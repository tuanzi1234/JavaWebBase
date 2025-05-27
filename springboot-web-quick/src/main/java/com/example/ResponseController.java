package com.example;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 响应数据:HttpServletResponse设置响应数据
 */
@RestController
public class ResponseController {
    //设定响应数据
    //方式一：使用HttpServletResponse
    @RequestMapping("/getResponse")
    public void getResponse(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//一般不指定状态码，由浏览器自动设定
        //2.设置响应头
        response.setHeader("name", "tuanzi");
        //3.设置响应体
        //手动调用 response.getWriter().write() 写入响应体。
        //方法返回 String 类型（return "success"），此时 Spring 会通过 @RestController 自动调用 getWriter() 再次写入返回值。
        //两者冲突导致 IllegalStateException。
        //将返回值类型改为void，不返回任何值，课解决上述异常
        response.getWriter().write("<h1>hello world</h1>");
        //return "success";
    }
    //方式二：使用ResponseEntity<T>
    @RequestMapping("/getResponse2")
    public ResponseEntity<String> getResponse2() {
        return ResponseEntity
                .status(HttpServletResponse.SC_UNAUTHORIZED)
                .header("name", "tuanzi")
                .body("<h1>hello world2</h1>");
    }
}
