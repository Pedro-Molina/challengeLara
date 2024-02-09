package com.lara.laraChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LaraChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaraChallengeApplication.class, args);
	}

}
