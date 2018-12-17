package fr.formation.proxi.metier;

<<<<<<< HEAD
import javax.persistence.DiscriminatorValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
=======
public class CurrentAccount extends Account {
>>>>>>> a3f60e9a9072ed91c8cdfdcbc58fea2d8d6417a5

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
