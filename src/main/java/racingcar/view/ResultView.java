package racingcar.view;

import java.util.Collections;

import racingcar.domain.RacingCars;
import racingcar.domain.WinnerRacingCarNames;

public class ResultView {

	private static final String RESULT_TITLE = "실행 결과";

	private static final String POSITION_BAR = "-";

	private static final String NEW_LINE = System.lineSeparator();

	private static final String SUFFIX_WINNER_RACING_CAR_NAME_MESSAGE = "가 최종 우승했습니다.";

	private ResultView() { }

	public static void printResultTitle() {
		System.out.println(NEW_LINE + RESULT_TITLE);
	}

	public static void printRacingCarsPosition(RacingCars racingCars) {
		StringBuilder sb = new StringBuilder();
		racingCars.toList().forEach(racingCar -> sb.append(racingCar.getCarName())
			.append(":")
			.append(getCarPositionBar(racingCar.getPosition()))
			.append(NEW_LINE));

		System.out.println(sb);
	}

	private static String getCarPositionBar(int position) {
		return String.join("", Collections.nCopies(position, POSITION_BAR));
	}

	public static void printWinnerRacingCarNames(WinnerRacingCarNames racingCarNames) {
		System.out.println(getWinnerRacingCarName(racingCarNames) + SUFFIX_WINNER_RACING_CAR_NAME_MESSAGE);
	}

	private static String getWinnerRacingCarName(WinnerRacingCarNames racingCarNames) {
		StringBuilder sb = new StringBuilder();
		racingCarNames.toList().forEach(carName -> sb.append(carName).append(", "));

		return sb.substring(0, sb.length() - 2);
	}

}
