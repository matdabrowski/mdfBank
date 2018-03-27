package mdf.bank.mdfwebappbackend.domain.loan.dao;

import mdf.bank.mdfwebappbackend.domain.loan.model.Loan;

import java.util.List;

public interface LoanDao {
    void addLoan(Loan loan);

    List<Loan> getLoanList(long customerId);
}
