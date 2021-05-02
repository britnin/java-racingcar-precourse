package racingcar.domain;

import java.util.List;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		validate(racingCars);

		this.racingCars = racingCars;
	}

	private void validate(List<RacingCar> racingCars) {
		if (racingCars == null || racingCars.size() == 0) {
			throw new IllegalArgumentException("경주할 자동자들이 존재하지 않습니다.");
		}

		for (RacingCar racingCar : racingCars) {
			validateRacingCar(racingCar);
		}
	}

	private void validateRacingCar(RacingCar racingCar) {
		if (racingCar == null) {
			throw new IllegalArgumentException("경주할 자동차가 존재하지 않습니다.");
		}
	}

	public void moveAll() {
		racingCars.forEach(RacingCar::move);
	}

}
