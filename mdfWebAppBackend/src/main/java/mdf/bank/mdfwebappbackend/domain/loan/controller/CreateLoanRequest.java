package mdf.bank.mdfwebappbackend.domain.loan.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
public class CreateLoanRequest {
	@ApiModelProperty("Customer login")
	private int customerLogin;
	@ApiModelProperty("Amount of loan")
	private int amount;
	@ApiModelProperty("Number of periods")
	private int period;

	@JsonCreator
	public CreateLoanRequest(
			@JsonProperty("customerLogin") int customerLogin,
			@JsonProperty("amount") int amount,
			@JsonProperty("period") int period) {
		this.customerLogin = customerLogin;
		this.amount = amount;
		this.period = period;
	}
}
