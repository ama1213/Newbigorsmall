package trumpgame;

public enum CardMark {
	Clubs("クラブ", 0),
	Diamond("ダイヤ", 1),
	Heart("ハート", 2),
	Spade("スペード", 3);
	
	private String markName;
	private int level;
	
	CardMark(String markName, int level) {
		this.markName = markName;
		this.level = level;
	}
	
	public String getMarkName() {
		return this.markName;
	}
	
	public int getLevel() {
		return this.level;
	}
}