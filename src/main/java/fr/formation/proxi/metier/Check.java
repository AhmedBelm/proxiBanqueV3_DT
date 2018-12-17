package fr.formation.proxi.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="check")
public class Check {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCheck;
	
	@Column
	private String sendingDate;
	
	@Column
	private LocalDate receiveDate;

	public Check() {
	}

	public Check(Integer idCheck, String sendingDate, LocalDate receiveDate) {
		this.idCheck = idCheck;
		this.sendingDate = sendingDate;
		this.receiveDate = receiveDate;
	}

	public Integer getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(Integer idCheck) {
		this.idCheck = idCheck;
	}

	public String getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(String sendingDate) {
		this.sendingDate = sendingDate;
	}

	public LocalDate getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(LocalDate receiveDate) {
		this.receiveDate = receiveDate;
	}
}
