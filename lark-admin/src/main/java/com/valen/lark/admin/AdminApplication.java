package com.valen.lark.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) // Spring Boot项目的核心注解，主要目的是开启自动配置
@Controller // 标明这是一个SpringMVC的Controller控制器
public class AdminApplication {

	 @RequestMapping("/hello")
	    @ResponseBody
	    public String hello() {
	        return "hello world";
	    }

	public static void main(String[] args) {
		 SpringApplication.run(AdminApplication.class, args);


	}

}
