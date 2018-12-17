package fr.formation.proxi.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idAccount;
	
	@Column
	private String wording;
	
	@Column
	private Float balance;
	
	@Column
	private String number;
	
	@Column
	private String openingDate;
	
	@OneToOne
	@JoinColumn(name="idCheck", referencedColumnName="idCheck")
	private Check check;
	
	@OneToOne
	@JoinColumn(name="idCard", referencedColumnName="idCard")
	private Card card;
	
	@Column
	private Boolean type;

	public Account() {
	}

	public Account(Integer idAccount, String wording, Float balance, String number, String openingDate, Boolean type) {
		this.idAccount = idAccount;
		this.wording = wording;
		this.balance = balance;
		this.number = number;
		this.openingDate = openingDate;
		this.type = type;
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
