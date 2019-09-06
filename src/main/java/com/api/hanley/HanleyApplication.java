package com.api.hanley;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //发现注解@Scheduled的任务并后台执行
@MapperScan("com.api.hanley.dao")
public class HanleyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HanleyApplication.class, args);
	}

}
