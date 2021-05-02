package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingRound;
import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RandomMovableStrategy;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private static final String INPUT_RACING_ROUND = "시도할 회수는 몇 회인가요?";

	private static final String SEPARATOR = ",";

	private static final MovableStrategy MOVABLE_STRATEGY = new RandomMovableStrategy();

	private InputView() { }

	public static RacingCars inputRacingCarNames() {
		System.out.println(INPUT_RACING_CAR_NAMES);
		String inputValue = SCANNER.nextLine();

		return createRacingCars(inputValue);
	}

	private static RacingCars createRacingCars(String inputValue) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (String carName : inputValue.split(SEPARATOR)) {
			racingCars.add(new RacingCar(carName, MOVABLE_STRATEGY));
		}

		return new RacingCars(racingCars);
	}

	public static RacingRound inputRacingRound() {
		System.out.println(INPUT_RACING_ROUND);
		return new RacingRound(SCANNER.nextInt());
	}

}
