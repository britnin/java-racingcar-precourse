package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerRacingCarNames {

	private final List<String> racingCarNames = new ArrayList<>();

	private final RacingCar winnerRacingCar;

	public WinnerRacingCarNames(RacingCar winnerRacingCar) {
		validate(winnerRacingCar);

		this.winnerRacingCar = winnerRacingCar;
	}

	private void validate(RacingCar winnerRacingCar) {
		if (winnerRacingCar == null) {
			throw new IllegalArgumentException("우승 자동차가 존재하지 않습니다.");
		}
	}

	public void add(RacingCar racingCar) {
		if (winnerRacingCar.compareTo(racingCar) == 0) {
			racingCarNames.add(racingCar.getName());
		}
	}

	public List<String> toList() {
		return Collections.unmodifiableList(racingCarNames);
	}

}
