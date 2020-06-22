package trumpgame;

public class BigOrSmall {

	private static final long StartChips = 100L;

	public static void main(String[] args) {
		Keyboard key = new Keyboard();
		Display display = new Display();
		Trump trump = new Trump();
		Chips chips = new Chips(StartChips);

		do {
			trump.shuffle();
			Card firstCard = trump.getCard();
			display.viewGameStart(chips, firstCard);
			long tableChip = chips.betChips(key.betValue(chips));
			while (true) {
				boolean bigOrSmall = key.isBigOrSmall(firstCard);
				Card secondCard = trump.getCard(firstCard);
				display.viewGameSituation(tableChip, bigOrSmall, firstCard, secondCard);
				if (bigOrSmall == firstCard.isBigOrSmall(secondCard)) {
					tableChip = chips.getReward(tableChip);
					display.viewWin(tableChip);
					if (key.isNextBet(tableChip)) {
						firstCard = secondCard;
						continue;
					}
					chips.payOff(tableChip);
				} else {
					display.viewLoss();
				}
				break;
			}
			display.viewGameResult(chips);
		} while (key.isGameEnd(chips));
		display.viewEnd();
		key.close();
	}
}
