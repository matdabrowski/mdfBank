package mdf.bank.mdfwebappbackend.domain.customer.controller;

import mdf.bank.mdfwebappbackend.core.service.CustomerDataService;
import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;
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
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerDataService customerDataService;

	public CustomerController(CustomerDataService customerDataService) {
		this.customerDataService = customerDataService;
	}

	@GetMapping("/data/{customerLogin}")
	public CustomerResponse getCustomer(@PathVariable("customerLogin") int customerLogin) {
		logger.info("Request for id {}", customerLogin);
		Customer customer = customerDataService.getCustomerData(customerLogin);
		logger.info("Customer Data {}", customer);
		return new CustomerResponse(customer.getLogin(), customer.getFirstName(), customer.getLastName());
	}
}
