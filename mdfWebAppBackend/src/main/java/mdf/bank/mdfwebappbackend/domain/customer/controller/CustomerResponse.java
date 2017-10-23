package mdf.bank.mdfwebappbackend.domain.customer.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@AllArgsConstructor
class CustomerResponse {
	private int login;
	private String firstName;
	private String lastName;
}
