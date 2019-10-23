package com.gitmuts.apachecamel;

import com.gitmuts.apachecamel.service.FileCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApachecamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApachecamelApplication.class, args);


	}

}
