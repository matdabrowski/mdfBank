package mdf.bank.mdfwebappbackend.infrastructure.loan.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mdf.bank.mdfwebappbackend.domain.loan.model.Loan;
import mdf.bank.mdfwebappbackend.domain.loan.dao.LoanDao;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Repository
public class LoanDaoImpl implements LoanDao {

	private static final String HTTP_MDF_LOAN_AND_DEPOSIT = "http://mdfLoanAndDeposit";
	private final RestTemplate restTemplate;

	public LoanDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	@HystrixCommand
	public void addLoan(Loan loan) {
		restTemplate.exchange(
				HTTP_MDF_LOAN_AND_DEPOSIT + "/loan",
				HttpMethod.POST,
				new HttpEntity<>(loan), String.class);
	}

	@Override
	@HystrixCommand
	public List<Loan> getLoanList(long customerId) {
		return restTemplate.exchange(
				HTTP_MDF_LOAN_AND_DEPOSIT + "/loan/list/" + customerId,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Loan>>() {}).getBody();
	}
}
