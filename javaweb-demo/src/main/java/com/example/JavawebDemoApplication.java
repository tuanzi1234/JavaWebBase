package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@SpringBootApplication是SpringBoot的核心注解
                      //@ComponentScan：自动扫描并加载符合条件的组件，包含@在SpringBootApplication中，默认扫描当前包及其子包下的所有组件。
public class JavawebDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavawebDemoApplication.class, args);
	}

}
