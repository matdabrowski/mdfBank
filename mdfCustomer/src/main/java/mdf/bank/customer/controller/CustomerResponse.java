package mdf.bank.customer.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@AllArgsConstructor
class CustomerResponse {
	private int Id;
	private int login;
	private String firstName;
	private String lastName;
}
