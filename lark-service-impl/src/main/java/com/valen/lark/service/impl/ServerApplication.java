package com.valen.lark.service.impl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * Hello world!
 *
 */
//Spring Boot 应用的标识
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.valen.lark"})
@MapperScan("com.valen.lark.dao")
public class ServerApplication {

 public static void main(String[] args) {
     // 程序启动入口
     // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
     SpringApplication.run(ServerApplication.class,args);
 }
}
