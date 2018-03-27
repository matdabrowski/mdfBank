package mdf.bank.mdfwebappbackend.domain.customer.dao;

import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;

public interface CustomerDataDao {
    Customer getCustomerData(int login);
}
