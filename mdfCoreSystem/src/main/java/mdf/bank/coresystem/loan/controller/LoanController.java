package mdf.bank.coresystem.loan.controller;

import mdf.bank.coresystem.domain.model.Loan;
import mdf.bank.coresystem.loan.service.LoanService;
import mdf.bank.coresystem.processor.LoanProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@RestController
@RequestMapping("/loan")
class LoanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanProcessor.class);

	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping
	public void openLoan(@RequestBody LoanRequest loanRequest) {
		LOGGER.info("Open Loan {}", loanRequest);
		loanService.openLoan(mapToLoan(loanRequest));
	}

	private Loan mapToLoan(LoanRequest loan) {
		return new Loan(loan.getAmount(), loan.getPeriod(), loan.getCustomerId());
	}

	@GetMapping("/list/{customerId}")
	public List<Loan> getListForCustomer(@PathVariable("customerId") long customerId) {
		LOGGER.info("Get loan list {}", customerId);
		return loanService.getLoanList(customerId);
	}
}
