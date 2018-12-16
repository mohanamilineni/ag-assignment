package com.ag.todoservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoTaskServicesApplication {

	public static void main(String[] args) {
		System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "[](){}");
		SpringApplication.run(TodoTaskServicesApplication.class, args);
	}

}

