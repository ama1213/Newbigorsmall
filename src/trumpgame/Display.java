package trumpgame;

public class Display {
	protected enum DesplayMessage{
		GameStart("*******チップ枚数とカード*******"+ getLineSeparator() +
				"総計：%d([10]: %d枚[1] : %d枚)" + getLineSeparator() +
				"現在のカード: %s" + getLineSeparator() +
				"********************************"),
		GameSituation("********************************" + getLineSeparator() +
				"BET数： %d" + getLineSeparator() +
				"あなたの選択： %s" + getLineSeparator() +
				"現在のカード： %s" + getLineSeparator() +
				"引いたカード： %s" + getLineSeparator() +
				"%s は %s より %s" + getLineSeparator() +
				"********************************"),
		GameWin("Win!!" + getLineSeparator() + "チップ%d枚を獲得しました " + getLineSeparator() + getLineSeparator()),
		GameLoss("Lose..." + getLineSeparator() + getLineSeparator()),
		GameResult("********現在のチップ枚数********" + getLineSeparator() +
				"総計：%d ([10]：%d枚 [1]：%d枚)" + getLineSeparator() +
				"********************************"),
		GameEnd("END"),
		BigSelect("Big"),
		SmallSelect("Small");
		
		public final String message;
		
		private DesplayMessage(String message) {
			this.message = message;
		}
		
		public String format(Object... args) {
			return String.format(message, args);
		}
	}
	
	public static void println(String string) {
		System.out.println(string);
	}
	
	public static String getLineSeparator() {
		return System.getProperty("line.separator");
	}
	
	public void viewGameStart(Chips chips, Card firstCard) {
		println(DesplayMessage.GameStart.format(
				chips.getTatal(),
				chips.getTenValue(),
				chips.getOneValue(),
				firstCard.toString()));
	}
	
	public void viewGameSituation(long tableChip, boolean bigOrSmall,Card firstCard, Card secondCard) {
		String select = (bigOrSmall) ? DesplayMessage.BigSelect.message : DesplayMessage.SmallSelect.message;
		String result = (firstCard.isBigOrSmall(secondCard)) ? DesplayMessage.BigSelect.message : DesplayMessage.SmallSelect.message;
		println(DesplayMessage.GameSituation.format(
				tableChip,
				select,
				firstCard.toString(),
				secondCard.toString(),
				firstCard.toString(),
				secondCard.toString(),
				result));
	}
	
	public void viewWin(long tableChip) {
		println(DesplayMessage.GameWin.format(tableChip));
	}
	
	public void viewLoss() {
		println(DesplayMessage.GameLoss.message);
	}
	
	public void viewGameResult(Chips chips) {
		println(DesplayMessage.GameResult.format(chips.getTatal(), chips.getTenValue(), chips.getOneValue()));
	}
	
	public void viewEnd() {
		println(DesplayMessage.GameEnd.message);
	}
}