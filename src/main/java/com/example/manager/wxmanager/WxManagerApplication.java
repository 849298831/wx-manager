package com.example.manager.wxmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.example.manager.wxmanager.dao")
public class WxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxManagerApplication.class, args);
	}

}
