package mdf.bank.mdfwebappbackend.application.customer.controller;

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
