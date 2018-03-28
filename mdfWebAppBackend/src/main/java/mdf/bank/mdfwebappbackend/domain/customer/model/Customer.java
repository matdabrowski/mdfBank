package mdf.bank.mdfwebappbackend.domain.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@AllArgsConstructor
@ToString
public class Customer {
    private int id;
    private int login;
    private String firstName;
    private String lastName;
}
