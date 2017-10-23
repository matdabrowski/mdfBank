package mdf.bank.coresystem.loan.service;

import mdf.bank.coresystem.domain.model.Loan;
import mdf.bank.coresystem.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Service
public class LoanService {

	private final LoanRepository loanRepository;

	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	public void openLoan(Loan loan) {
		loanRepository.save(loan);
	}

	public List<Loan> getLoanList(long customerId) {
		return loanRepository.findByCustomerId(customerId);
	}

}
