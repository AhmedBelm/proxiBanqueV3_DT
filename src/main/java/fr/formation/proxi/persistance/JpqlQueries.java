package fr.formation.proxi.persistance;

/**
 * Classe contenant sous forme de constantes l'ensemble des requetes necessaires aux manipulations de la base de donnees.
 * 
 * @author Adminl
 *
 */
public class JpqlQueries {

	public static final String READ_ALL_CLIENT = "Select c FROM Client c";
	public static final String READ_ALL_ACCOUNT = "Select a FROM Account a";
	public static final String READ_ALL_CARD = "Select b FROM Card b";
	public static final String READ_ALL_CHECK = "Select c FROM Check c";
	
	public static final String SELECT_CLIENT_BY_NAME = "SELECT c FROM Client c where lastname=:lastname and firstname=:firstname";
}
