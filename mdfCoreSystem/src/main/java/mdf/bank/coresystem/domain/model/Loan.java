package mdf.bank.coresystem.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@Setter
@ToString
public class Loan {
	@Id
	private String id;
	private int amount;
	private int period;
	private long customerId;
	private LocalDateTime startDate;
	private LoanStatus status = LoanStatus.PENDING;

	public Loan(int amount, int period, long customerId) {
		this.amount = amount;
		this.period = period;
		this.customerId = customerId;
	}
}
