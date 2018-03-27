package mdf.bank.mdfwebappbackend.application.loan.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mdf.bank.mdfwebappbackend.domain.loan.model.Loan;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class LoanDto {
	private int amount;
	private int period;
	private String status;
	private LocalDateTime startDate;

	static LoanDto from(Loan loan) {
		return new LoanDto(loan
				.getAmount(), loan.getPeriod(), loan.getStatus(), loan.getStartDate());
	}
}
