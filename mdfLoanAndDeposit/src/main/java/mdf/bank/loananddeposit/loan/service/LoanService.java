package mdf.bank.loananddeposit.loan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mdf.bank.loananddeposit.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Service
public class LoanService {

	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
	private final CoreLoanService coreLoanService;

	public LoanService(CoreLoanService coreLoanService) {
		this.coreLoanService = coreLoanService;
	}

	@HystrixCommand
	public void addLoan(Loan loan) {
		coreLoanService.openLoanInCoreSystem(loan);
	}

	@HystrixCommand
	public List<Loan> getLoanList(long customerId) {
		List<Loan> loanList = coreLoanService.getLoanList(customerId);
		logger.info("Loan portfolio size: " + loanList.size());
		return loanList;
	}
}
