package mdf.bank.loananddeposit.loan.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
@Document
public class Loan {

	@Id
	private String id;
	private int amount;
	private int period;
	private long customerId;
	private LoanStatus status;
	private LocalDateTime openDate;
	private LocalDateTime startDate;

	public Loan() {
	}

	public Loan(String id, int amount, int period, long customerId, LoanStatus status, LocalDateTime openDate, LocalDateTime startDate) {
		this.id = id;
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
		this.status = status;
		this.openDate = openDate;
		this.startDate = startDate;
	}

	public Loan(int amount, int period, long customerId, LoanStatus status, LocalDateTime openDate, LocalDateTime startDate) {
		this(null, amount, period, customerId, status, openDate, startDate);
	}

	public Loan(int amount, int period, long customerId, LoanStatus status, LocalDateTime openDate) {
		this(amount, period, customerId, status, openDate, null);
	}
}
