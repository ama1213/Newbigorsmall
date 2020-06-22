package trumpgame;

import java.util.Scanner;

public class Keyboard {
	protected enum InputError {
		NumericCharacters("半角数字を入力してください"),
		MinimumBet("BETするチップ数は、最低%d以上を入力してください"),
		MaxmumBet("BETするチップ数は、最大%d以下で入力してください"),
		NumericZeroOrOwn("半角数字の0あるいは1のみ入力してください");
		
		public final String message;
		
		private InputError(String message) {
			this.message = message;
		}
		
		public String format(Object... args) {
			return String.format(message, args);
		}
	}
	
	protected enum Prompt {
		Betting("■BET枚数選択\r\nBETするチップ数を入力してください(最低%d～最大%d)"),
		NextBetting("[獲得したチップ%d枚でBig or Smallを続けますか?]： 0:Yes 1:No"),
		BigOrSmall("[Big or Small]： 0:Big 1:Small"),
		GameEnd("[ゲームを続けますか?]： 0:Yes 1:NO"),
		NoChips("チップの総計が0になりましたので終了します。"),
		BigOrSmallSelecter("■Big or Small選択" + Display.getLineSeparator() + "現在のカード： %s");
		
		public final String message;
		
		private Prompt(String message) {
			this.message = message;
		}
		
		public String format(Object... args) {
			return String.format(message, args);
		}
	}
	
	private Scanner scanner = null;
	
	public Keyboard() {
		this.scanner = new Scanner(System.in);
	}
	
	public void close() {
		this.scanner.close();
	}
	
	public long betValue(Chips chips) {
		long result = 0;
		while(true) {
			Display.println(Prompt.Betting.format(chips.getMinBetValue(),chips.getMaxBetValue()));
			String in = scanner.nextLine();
			try {
				result = Long.parseLong(in);
			} catch (NumberFormatException e) {
				Display.println(InputError.NumericCharacters.message);
				continue;
			}
			if(chips.getMinBetValue() >result) {
				Display.println(InputError.MinimumBet.format(chips.getMinBetValue()));
			} else if (chips.getMaxBetValue() < result) {
				Display.println(InputError.MaxmumBet.format(chips.getMaxBetValue()));
			}else {
				break;
			}
		}
		return result;
	}
	
	public boolean isBigOrSmall(Card firstCard) {
		Display.println(Prompt.BigOrSmallSelecter.format(firstCard.toString()));
		return isKeyIn(Prompt.BigOrSmall.message);
	}
	
	public boolean isNextBet(long bet) {
		return isKeyIn(Prompt.NextBetting.format(bet));
	}
	
	public boolean isGameEnd(Chips chips) {
		if(0 >= chips.getTatal()) {
			Display.println(Prompt.NoChips.message);
			return false;
		}
		return isKeyIn(Prompt.GameEnd.message);
	}
	
	private boolean isKeyIn(String out) {
		while(true) {
			if(!"".equals(out)) {
				Display.println(out);
			}
			switch (getKeyIn()) {
			case 0:
				return true;
			case 1:
				return false;
			}
		}
	}
	
	private int getKeyIn() {
		int result;
		String in = scanner.nextLine();
		try {
			result = Integer.parseInt(in);
		} catch (NumberFormatException e) {
			Display.println(InputError.NumericCharacters.message);
			return -1;
		}
		switch(result) {
		case 0:
		case 1:
			break;
		default:
			Display.println(InputError.NumericZeroOrOwn.message);
			return -1;
		}
		return result;
	}
}