package com.ah_service.dps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/ah_service/dps/dao")
@EnableAutoConfiguration
public class DpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsApplication.class, args);
	}
}
