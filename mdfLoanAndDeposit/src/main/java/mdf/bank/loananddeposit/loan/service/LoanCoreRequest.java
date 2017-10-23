package mdf.bank.loananddeposit.loan.service;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
class LoanCoreRequest {
	private int amount;
	private int period;
	private long customerId;
	private LocalDateTime startDate;
	private String externalId;

	public LoanCoreRequest(int amount, int period, long customerId, LocalDateTime startDate, String externalId) {
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
		this.startDate = startDate;
		this.externalId = externalId;
	}
}
