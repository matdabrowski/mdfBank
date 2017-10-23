package mdf.bank.mdfwebappbackend.domain.loan.controller;

import mdf.bank.mdfwebappbackend.core.service.CustomerDataService;
import mdf.bank.mdfwebappbackend.domain.customer.model.Customer;
import mdf.bank.mdfwebappbackend.domain.loan.model.Loan;
import mdf.bank.mdfwebappbackend.domain.loan.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Mateusz Dąbrowski
 */
@RestController
@RequestMapping("/loan")
class LoanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

	private final LoanService loanService;
	private final CustomerDataService customerDataService;

	public LoanController(LoanService loanService, CustomerDataService customerDataService) {
		this.loanService = loanService;
		this.customerDataService = customerDataService;
	}

	@PostMapping
	public void addLoan(@Valid @RequestBody CreateLoanRequest createLoanRequest) {
		LOGGER.info("Loan for customer: {}", createLoanRequest);
		Customer customerData = customerDataService.getCustomerData(createLoanRequest.getCustomerLogin());
		loanService.addLoan(mapToLoan(createLoanRequest, customerData.getId()));
	}

	private Loan mapToLoan(CreateLoanRequest createLoanRequest, int customerId) {
		return new Loan(createLoanRequest.getAmount(), createLoanRequest.getPeriod(), customerId, null, null);
	}

	@GetMapping("/list/{customerLogin}")
	public List<LoanDto> getLoanList(@PathVariable("customerLogin") int customerLogin) {
		LOGGER.info("Loan for customer: {}", customerLogin);
		Customer customerData = customerDataService.getCustomerData(customerLogin);
		LOGGER.info("Get customer data: {} ", customerData);
		return loanService.getLoanList(customerData.getId())
				.stream()
				.map(LoanDto::from)
				.collect(toList());
	}
}
