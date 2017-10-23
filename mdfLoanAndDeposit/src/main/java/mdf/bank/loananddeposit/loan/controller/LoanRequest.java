package mdf.bank.loananddeposit.loan.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
public class LoanRequest {
	private int amount;
	private int period;
	private long customerId;

	@JsonCreator
	public LoanRequest(@JsonProperty("amount") int amount,
					   @JsonProperty("period") int period,
					   @JsonProperty("customerId") long customerId) {
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
	}
}