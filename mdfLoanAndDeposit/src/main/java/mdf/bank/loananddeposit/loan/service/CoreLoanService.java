package mdf.bank.loananddeposit.loan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mdf.bank.loananddeposit.loan.model.Loan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Service
public class CoreLoanService {

	private final RestTemplate restTemplate;

	public CoreLoanService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@HystrixCommand
	void openLoanInCoreSystem(Loan loan) {
		restTemplate.exchange(
				"http://mdfCoreSystem/loan",
				HttpMethod.POST,
				new HttpEntity<>(mapToLoanRequest(loan)), String.class);
	}

	private LoanCoreRequest mapToLoanRequest(Loan loan) {
		return new LoanCoreRequest(loan.getAmount(), loan.getPeriod(), loan.getCustomerId(), loan.getOpenDate(), loan.getId());
	}

	@HystrixCommand
	List<Loan> getLoanList(long customerId) {
		return restTemplate.exchange(
				"http://mdfCoreSystem/loan/list/" + customerId,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Loan>>() {}).getBody();
	}
}
