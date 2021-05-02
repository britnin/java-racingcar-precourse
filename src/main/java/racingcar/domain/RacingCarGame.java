package racingcar.domain;

import racingcar.view.ResultView;

public class RacingCarGame {

	private final RacingCars racingCars;

	private final RacingRound racingRound;

	public RacingCarGame(RacingCars racingCars, RacingRound racingRound) {
		validate(racingCars, racingRound);

		this.racingCars = racingCars;
		this.racingRound = racingRound;
	}

	private void validate(RacingCars racingCars, RacingRound racingRound) {
		if (racingCars == null) {
			throw new IllegalArgumentException("경주할 자동차 리스트가 존재하지 않습니다.");
		}

		if (racingRound == null) {
			throw new IllegalArgumentException("이동 횟수가 존재하지 않습니다.");
		}
	}

	public void play() {
		ResultView.printResultTitle();

		while (racingRound.hasNext()) {
			racingCars.moveAll();
			ResultView.printRacingCarsPosition(racingCars);
		}

		ResultView.printWinnerRacingCarNames(racingCars.getWinnerRacingCarNames());
	}

}
