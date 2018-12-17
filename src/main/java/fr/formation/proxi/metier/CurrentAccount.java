package fr.formation.proxi.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue ("current")
public class CurrentAccount extends Account {

	@OneToOne
	@JoinColumn(name="idCard", referencedColumnName="idCard")
	private Card card;
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
