package mdf.bank.mdfwebappbackend.infrastructure.customer.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;
import mdf.bank.mdfwebappbackend.domain.customer.dao.CustomerDataDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mateusz Dąbrowski
 */
@Repository
public class CustomerDataDaoImpl implements CustomerDataDao {

	private final RestTemplate restTemplate;

	public CustomerDataDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	@HystrixCommand
	public Customer getCustomerData(int login) {
		return restTemplate
				.getForEntity("http://mdfCustomer/customer/data/" + login, Customer.class)
				.getBody();
	}
}
