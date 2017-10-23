package mdf.bank.loananddeposit.loan.controller;

import mdf.bank.loananddeposit.loan.model.Loan;
import mdf.bank.loananddeposit.loan.model.LoanStatus;
import mdf.bank.loananddeposit.loan.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@RestController
@RequestMapping("/loan")
public class LoanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping
	public void addLoan(@Valid @RequestBody LoanRequest loanRequest) {
		LOGGER.info("Open Loan {}", loanRequest);
		loanService.addLoan(
				new Loan(
						loanRequest.getAmount(),
						loanRequest.getPeriod(),
						loanRequest.getCustomerId(),
						LoanStatus.PENDING,
						LocalDateTime.now()
				)
		);
	}

	@GetMapping("/list/{customerId}")
	public List<Loan> getLoanList(@PathVariable("customerId") long customerId) {
		LOGGER.info("List lona for customer: {}", customerId);
		return loanService.getLoanList(customerId);
	}
}
