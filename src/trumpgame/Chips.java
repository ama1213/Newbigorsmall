package trumpgame;

public class Chips {
	private final long MaxBetValue = 20;
	private final long MinBetValue = 1;
	private long value = 0;
	
	public Chips(long value) {
		this.value = value;
	}
	
	public long betChips(long bet) {
		value -= bet;
		return bet;
	}
	
	public void payOff(long tableChip) {
		if( 0 >value + tableChip ) {
			value = tableChip;
		}else {
			value += tableChip;
		}
	}
	
	public long getReward(long tableChip) {
		return tableChip *2;
	}
	
	public long getTatal() {
		return value;
	}
	
	public long getTenValue() {
		return value / 10;
	}
	
	public long getOneValue() {
		return value %10;
	}
	
	public long getMaxBetValue() {
		if (MaxBetValue > value) {
			return value;
		}
		return MaxBetValue;
	}
	
	public long getMinBetValue() {
		return MinBetValue;
	}
}
