package mdf.bank.adminconsole;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableAdminServer
@EnableTurbine
public class AdminConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminConsoleApplication.class, args);
	}
}
