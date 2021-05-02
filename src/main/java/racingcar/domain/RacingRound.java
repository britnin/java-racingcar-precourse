package racingcar.domain;

public class RacingRound {

	private int round;

	public RacingRound(int round) {
		validate(round);

		this.round = round;
	}

	private void validate(int round) {
		if (round <= 0) {
			throw new IllegalArgumentException("이동 횟수는 0보다 커야 합니다.");
		}
	}

	public boolean hasNext() {
		return (round-- > 0);
	}

}
