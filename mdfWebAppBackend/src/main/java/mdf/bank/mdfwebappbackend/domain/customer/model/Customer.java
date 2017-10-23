package mdf.bank.mdfwebappbackend.domain.customer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@Setter
@ToString
public class Customer {
	private int id;
	private int login;
	private String firstName;
	private String lastName;
}
