package mdf.bank.coresystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MdfCoreSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdfCoreSystemApplication.class, args);
	}
}
