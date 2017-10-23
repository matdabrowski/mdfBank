package mdf.bank.customer.configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;

/**
 * @author Mateusz Dąbrowski
 */
@Configuration
public class Config {

	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private int mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String database;

	@PostConstruct
	public void init() {
		initMongeez();
	}

	private void initMongeez() {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("mongeez.xml"));
		mongeez.setMongo(new MongoClient(new ServerAddress(mongoHost, mongoPort)));
		mongeez.setDbName(database);
		mongeez.process();
	}

}
