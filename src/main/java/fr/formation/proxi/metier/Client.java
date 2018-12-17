package fr.formation.proxi.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idClient;

	@Column
	private String number;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String birthDate;

	@OneToOne

	@JoinColumn(name = "idAddress", referencedColumnName = "idAddress")
	private Address address;

	@OneToMany
	@JoinColumn(name = "idClient")
	private List<Account> accounts;

	public Client() {
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Client(Integer idClient, String birthDate, String firstname, String lastname, String number,
			List<Account> accounts) {
		this.idClient = idClient;
		this.number = number;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.accounts = accounts;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
