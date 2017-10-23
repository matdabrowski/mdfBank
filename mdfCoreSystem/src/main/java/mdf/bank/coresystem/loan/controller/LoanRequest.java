package mdf.bank.coresystem.loan.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
class LoanRequest {
	private int amount;
	private int period;
	private long customerId;
	private String externalId;

	@JsonCreator
	public LoanRequest(@JsonProperty("amount") int amount,
					   @JsonProperty("period") int period,
					   @JsonProperty("customerId") long customerId,
					   @JsonProperty("externalId") String externalId) {
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
		this.externalId = externalId;
	}
}
