package mdf.bank.mdfwebappbackend.infrastructure.mock;

import mdf.bank.mdfwebappbackend.domain.customer.dao.CustomerDataDao;
import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Mateusz Dąbrowski
 */
@Repository
@Profile({"dev","test"})
public class CustomerDataDaoMock implements CustomerDataDao {

	@Override
	public Customer getCustomerData(int login) {
		return new Customer(1, login, "Mock", "Mockre");
	}
}
