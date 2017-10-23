package mdf.bank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MdfCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdfCustomerApplication.class, args);
	}
}
