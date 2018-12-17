package fr.formation.proxi.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCard;
	
	@Column
	private String number;
		
	@Column
	private Boolean type;
	
	@Column
	private LocalDate expDate;

	public Card() {
	}

	public Card(Integer idCard, String number, Boolean type, LocalDate expDate) {
		this.idCard = idCard;
		this.number = number;
		this.type = type;
		this.expDate = expDate;
	}

	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
