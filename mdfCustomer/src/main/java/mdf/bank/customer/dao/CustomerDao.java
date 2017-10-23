package mdf.bank.customer.dao;

import mdf.bank.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mateusz Dąbrowski
 */
@Repository
public interface CustomerDao extends MongoRepository<Customer, Integer> {
	Customer findByLogin(Integer login);
}
