package com.graphql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootGraphqlMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGraphqlMysqlApplication.class, args);
	}

}
