package com.ahmadarif.aop;

import com.ahmadarif.aop.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopApplication implements CommandLineRunner {

	@Autowired
	private HelloWorldService helloWorldService;

	@Override
	public void run(String... strings) throws Exception {
		helloWorldService.setName("Ahmad Arif");
		System.out.println();
		System.out.println(helloWorldService.getHelloMessage());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

}