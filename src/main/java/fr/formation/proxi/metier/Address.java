package fr.formation.proxi.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe correspondant à l'adresse du client
 * 
 * @author Ahmed & Sidney
 */
@Entity
@Table (name="address")
public class Address {

	/**
	 * Identifiant de l'adresse dans la base de donnée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idAddress;
	
	/**
	 * Pays correspondant à l'adresse
	 */
	@Column
	private String country;
	
	/**
	 * Code postal correspondant à l'adresse
	 */
	@Column
	private String zipCode;
	
	/**
	 * Elementas principaux de l'adresse
	 */
	private String principal;
	
	/**
	 * Elements secondaire de l'adresse
	 */
	private String secondary;

	/**
	 * Constructeur sans argument
	 */
	public Address() {
	}

	/**
	 * Constructeur avec argumentss
	 */
	public Address(Integer idAddress, String country, String zipCode, String principal, String secondary) {
		this.idAddress = idAddress;
		this.country = country;
		this.zipCode = zipCode;
		this.principal = principal;
		this.secondary = secondary;
	}

	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
}
