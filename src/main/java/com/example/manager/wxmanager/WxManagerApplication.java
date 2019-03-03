package com.example.manager.wxmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.manager.wxmanager.dao")
public class WxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxManagerApplication.class, args);
	}

}
