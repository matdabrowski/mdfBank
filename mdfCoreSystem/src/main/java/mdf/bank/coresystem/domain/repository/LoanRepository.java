package mdf.bank.coresystem.domain.repository;

import mdf.bank.coresystem.domain.model.Loan;
import mdf.bank.coresystem.domain.model.LoanStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mateusz Dąbrowski
 */
@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {

	List<Loan> findAllByStatus(LoanStatus loanStatus);

	List<Loan> findByCustomerId(long id);
}
