package com.snykta.admin;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class FastAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastAdminApplication.class, args);
	}

}
