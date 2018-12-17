package fr.formation.proxi.metier;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue ("saving")
public class SavingsAccount extends Account {

}
