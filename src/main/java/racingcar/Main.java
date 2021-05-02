package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingRound;
import racingcar.view.InputView;

public class Main {

	public static void main(String[] args) {
		RacingCars racingCars = InputView.inputRacingCarNames();
		RacingRound racingRound = InputView.inputRacingRound();

		RacingCarGame racingCarGame = new RacingCarGame(racingCars, racingRound);
		racingCarGame.play();
	}

}
