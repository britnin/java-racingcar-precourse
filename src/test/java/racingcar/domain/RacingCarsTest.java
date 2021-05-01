package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RandomMovableStrategy;

class RacingCarsTest {

	private static final MovableStrategy MOVABLE_STRATEGY = new RandomMovableStrategy();

	@Test
	@DisplayName("경주할 자동자 일급 컬렉션을 생성할 수 있다.")
	void successToCreateRacingCars() {
		RacingCars racingCars = new RacingCars(Arrays.asList(new RacingCar("붕붕이1", MOVABLE_STRATEGY)));
		assertThat(racingCars).isInstanceOf(RacingCars.class);
	}

	@Test
	@DisplayName("경주할 자동자가 존재하지 않으면 일급 컬렉션을 생성할 수 없다.")
	void failToCreateRacingCarsIfRacingCarNotExists() {
		assertThatThrownBy(() -> new RacingCars(null))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new RacingCars(Arrays.asList()))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new RacingCars(Arrays.asList(new RacingCar("붕붕이1", MOVABLE_STRATEGY), null)))
			.isInstanceOf(IllegalArgumentException.class);
	}

}