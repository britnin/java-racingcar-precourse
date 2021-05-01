package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.strategy.RandomMovableStrategy;

class RacingCarTest {

	@Test
	@DisplayName("이름과 이동 전략을 가진 자동자를 생성할 수 있다.")
	void successToCreateRacingCarWithNameAndMovableStrategy() {
		RacingCar car = new RacingCar("테스트", new RandomMovableStrategy());
		assertThat(car.getName()).isEqualTo("테스트");
	}

	@DisplayName("이름이 존재하지 않거나 길이가 5 초과하면 자동차를 생성할 수 없다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "123456" })
	void failToCreateRacingCarIfNameIsNullOrEmptyOrLength5Exceeds(String name) {
		assertThatThrownBy(() -> new RacingCar(name, new RandomMovableStrategy()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이동 전략이 존재하지 않으면 자동자를 생성할 수 없다.")
	void failToCreateRacingCarIfMovableStrategyIsNull() {
		assertThatThrownBy(() -> new RacingCar("붕붕이", null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차는 이동 전략으로 이동할 수 있다.")
	@ParameterizedTest
	@CsvSource({ "true,1", "false,0" })
	void canMoveRacingCarByMovableStrategy(boolean isMovable, int result) {
		RacingCar racingCar = new RacingCar("붕붕이", () -> isMovable);
		RacingCar other = new RacingCar("상대붕붕이", () -> isMovable);
		racingCar.move();

		assertThat(racingCar.compareTo(other)).isSameAs(result);
	}

}