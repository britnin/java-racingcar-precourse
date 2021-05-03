package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.strategy.RandomMovableStrategy;

class RacingCarTest {

	private static final CarName CAR_NAME = new CarName("붕붕이");

	@Test
	@DisplayName("이름과 이동 전략을 가진 자동자를 생성할 수 있다.")
	void successToCreateRacingCarWithNameAndMovableStrategy() {
		RacingCar car = new RacingCar(CAR_NAME, new RandomMovableStrategy());
		assertThat(car).isInstanceOf(RacingCar.class);
	}

	@Test
	@DisplayName("자동차 이름이 존재하지 않으면 자동차를 생성할 수 없다.")
	void failToCreateRacingCarIfNameIsNullOrEmptyOrLength5Exceeds() {
		assertThatThrownBy(() -> new RacingCar(null, new RandomMovableStrategy()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이동 전략이 존재하지 않으면 자동자를 생성할 수 없다.")
	void failToCreateRacingCarIfMovableStrategyIsNull() {
		assertThatThrownBy(() -> new RacingCar(CAR_NAME, null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차는 이동 전략으로 이동할 수 있다.")
	@ParameterizedTest
	@CsvSource({ "true,1", "false,0" })
	void canMoveRacingCarByMovableStrategy(boolean isMovable, int result) {
		RacingCar racingCar = new RacingCar(CAR_NAME, () -> isMovable);
		RacingCar other = new RacingCar(new CarName("상대붕붕이"), () -> isMovable);
		racingCar.move();

		assertThat(racingCar.compareTo(other)).isSameAs(result);
	}

}