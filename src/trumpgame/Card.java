package trumpgame;

import java.util.ArrayList;

public class Card implements Comparable<Card> {
	private static final int MinNumber = 1;
	private static final int MaxNumber = 13;
	private int number;
	private CardMark mark;

	public static ArrayList<Card> getNewInstance(CardMark mark) {
		ArrayList<Card> result = new ArrayList<Card>();
		for (int i = MinNumber; i <= MaxNumber; i++) {
			result.add(new Card(i, mark));
		}
		return result;
	}

	public Card(int number, CardMark mark) {
		this.number = number;
		this.mark = mark;
	}

	public int getNumber() {
		return number;
	}

	public CardMark getMark() {
		return mark;
	}

	public boolean isBigOrSmall(Card c) {
		if (0 < compareTo(c)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.mark.getMarkName() + String.format("%2d", this.number);
	}

	@Override
	public int compareTo(Card o) {
		if (this.number == o.getNumber()) {
			return this.mark.getLevel() - o.getMark().getLevel();
		}
		return this.number - o.getNumber();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			if (0 == this.compareTo((Card) obj)) {
				return true;
			}
		}
		return false;
	}
}
