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

import fr.formation.proxi.metier.Account;

/**
 * Classe représentant le client
 * 
 * @author Ahmed & Sidney
 *
 */
@Entity
@Table(name = "client")
public class Client {

	/**
	 * Identifiant du client dans la base de donnée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idClient;

	/**
	 * Numéro du client
	 */
	@Column
	private String number;

	/**
	 * Prénom du client
	 */
	@Column
	private String firstname;

	/**
	 * Nom du client
	 */
	@Column
	private String lastname;

	/**
	 * Date de naissance du client
	 */
	@Column
	private String birthDate;

	/**
	 * Adresse du client
	 */
	@OneToOne
	@JoinColumn(name = "idAddress", referencedColumnName = "idAddress")
	private Address address;

	/**
	 * Liste des comptes du client
	 */
	@OneToMany
	@JoinColumn(name = "idClient")
	private List<Account> accounts;

	/**
	 * constructeur sans attribut
	 */
	public Client() {
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Constructeur avec attributs
	 * 
	 * @param idClient
	 * @param birthDate
	 * @param firstname
	 * @param lastname
	 * @param number
	 * @param accounts
	 */
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
	
	/**
	 * Méthode permettant de recupérer les comptes grace à l'Id du client
	 * 
	 * @param searchId
	 * @return
	 */
	public Account getAccountById(Integer searchId) {
        Account result = null;
        for (Account a : this.accounts) {
            if (a.getIdAccount().equals(searchId)) {
                result = a;
                break;
            }
        }
        return result;
    }
}
