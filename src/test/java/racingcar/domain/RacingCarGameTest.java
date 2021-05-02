package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

	@Test
	@DisplayName("자동자 경주게임을 생성할 수 있다.")
	void successToCreateRacingCarGame() {
		RacingCars racingCars = new RacingCars(Arrays.asList(new RacingCar("붕붕이", () -> true)));
		RacingCarGame racingCarGame = new RacingCarGame(racingCars, new RacingRound(1));
		assertThat(racingCarGame).isInstanceOf(RacingCarGame.class);
	}

	@Test
	@DisplayName("경주용 자동차가 존재하지 않으면 자동자 경주게임을 생성할 수 없다.")
	void failToCreateRacingCarGameIfRacingCarsIsNull() {
		assertThatThrownBy(() -> new RacingCarGame(null, new RacingRound(1)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이동횟수가 존재하지 않으면 자동자 경주게임을 생성할 수 없다.")
	void failToCreateRacingCarGameIfRacingRoundIsNull() {
		assertThatThrownBy(() -> new RacingCarGame(new RacingCars(Arrays.asList(new RacingCar("붕붕이", () -> true))), null))
			.isInstanceOf(IllegalArgumentException.class);
	}

}