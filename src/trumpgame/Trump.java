package trumpgame;

import java.util.ArrayList;
import java.util.Collections;

public class Trump extends ArrayList<Card> {
	
	public Trump() {
		super();
		this.clear();
		this.addAll( Card.getNewInstance(CardMark.Clubs));
		this.addAll( Card.getNewInstance(CardMark.Diamond));
		this.addAll( Card.getNewInstance(CardMark.Heart));
		this.addAll( Card.getNewInstance(CardMark.Spade));
	}
	
	public void shuffle() {
		Collections.shuffle(this);
	}
	
	public Card getCard() {
		Card result = this.remove(0);
		this.add(result);
		return result;
	}
	
	public Card getCard(Card c) {
		Card result = getCard();
		if (result.equals(c)) {
			result = getCard();
		}
		return result;
	}
}