package fr.formation.proxi.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant le chéquier d'un client correspondant à un compte défini
 * 
 * @author Ahmet & Sidney
 *
 */
@Entity
@Table (name="cheque")
public class Check {

	/**
	 * Identifiant du chéquier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCheck;
	
	/**
	 * Date d'envoie du chéquier
	 */
	@Column
	private String sendingDate;
	
	/**
	 * Date de réception du chéquier
	 */
	@Column
	private LocalDate receiveDate;

	/**
	 * Constructeur sans attribut
	 */
	public Check() {
	}

	/**
	 * Constructeur avec attributs
	 * 
	 * @param idCheck
	 * @param sendingDate
	 * @param receiveDate
	 */
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
