package com.Forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 *	@Author	  ZFFFlower  ——2020年1月9日
 *	
 * 
 */
@ComponentScan(basePackages = {"com.Forum.*"})
@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
