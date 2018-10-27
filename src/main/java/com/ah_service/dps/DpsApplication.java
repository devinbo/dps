package com.ah_service.dps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/ah_service/dps/dao")
public class DpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsApplication.class, args);
	}
}
