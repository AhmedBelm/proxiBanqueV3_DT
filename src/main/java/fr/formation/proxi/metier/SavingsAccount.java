package fr.formation.proxi.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant les comptes épargnes et héritant de la classse Account
 * 
 * @author Ahmed & Sidney
 *
 */
@Entity
@DiscriminatorValue ("saving")
public class SavingsAccount extends Account {

}
