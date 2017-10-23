package mdf.bank.coresystem.processor;

import mdf.bank.coresystem.domain.model.Loan;
import mdf.bank.coresystem.domain.model.LoanStatus;
import mdf.bank.coresystem.domain.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Component
@EnableScheduling
public class LoanProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanProcessor.class);

	private final LoanRepository loanRepository;

	public LoanProcessor(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	// in millis
	@Scheduled(fixedDelay = 30 * 1000, initialDelay =  20 * 1000)
	void ProcessLoans() {
		LOGGER.info(".");
		List<Loan> pending = loanRepository.findAllByStatus(LoanStatus.PENDING);
		pending.forEach(loan -> {
			loan.setStatus(LoanStatus.STARTED);
			loan.setStartDate(LocalDateTime.now());
			LOGGER.info("Starting Loan {}", loan);
			loanRepository.save(loan);
		});
	}
}
