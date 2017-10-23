package mdf.bank.mdfwebappbackend.core.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mateusz Dąbrowski
 */
@Service
public class CustomerDataService {

	private final RestTemplate restTemplate;

	public CustomerDataService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@HystrixCommand
	public Customer getCustomerData(int login) {
		return restTemplate
				.getForEntity("http://mdfCustomer/customer/data/" + login, Customer.class)
				.getBody();
	}
}
