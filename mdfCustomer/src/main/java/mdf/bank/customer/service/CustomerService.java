package mdf.bank.customer.service;

import mdf.bank.customer.dao.CustomerDao;
import mdf.bank.customer.model.Customer;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dąbrowski
 */
@Service
public class CustomerService {

	private final CustomerDao customerDao;

	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer getCustomer(Integer login) {
		return customerDao.findByLogin(login);
	}
}
