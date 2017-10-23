package mdf.bank.customer.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mateusz Dąbrowski
 */
@Getter
@ToString
@Document(collection = "customer")
public class Customer {
	@Id
	private Integer id;
	@Indexed(unique = true)
	private Integer login;
	private String firstName;
	private String lastName;

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
