package mdf.bank.mdfwebappbackend.domain.loan.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
public class Loan {
	private int amount;
	private int period;
	private int customerId;
	private String status;
	private LocalDateTime startDate;

	@JsonCreator
	public Loan(
			@JsonProperty("amount") int amount,
			@JsonProperty("period") int period,
			@JsonProperty("customerId") int customerId,
			@JsonProperty("status") String status,
			@JsonProperty("startDate") LocalDateTime startDate) {
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
		this.status = status;
		this.startDate = startDate;
	}
}
