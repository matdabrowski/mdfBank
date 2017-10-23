package mdf.bank.customer.controller;

import mdf.bank.customer.model.Customer;
import mdf.bank.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mateusz Dąbrowski
 */
@RestController
@RequestMapping("/customer")
class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/data/{login}")
	public CustomerResponse getCustomer(@PathVariable("login") Integer login) {
		Customer customer = customerService.getCustomer(login);
		LOGGER.info("Customer Data: {}", customer);
		return mapToCustomerResponse(customer);
	}

	private CustomerResponse mapToCustomerResponse(Customer customer) {
		return new CustomerResponse(customer.getId(), customer.getLogin(), customer.getFirstName(), customer.getLastName());
	}
}
