package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerRacingCarNamesTest {

	@Test
	@DisplayName("우승 경주용 자동자 이름 일급 컬렉션을 생성할 수 있다.")
	void successToCreateWinnerRacingCarNames() {
		WinnerRacingCarNames racingCarNames = new WinnerRacingCarNames(new RacingCar("붕붕이", () -> true));
		assertThat(racingCarNames).isInstanceOf(WinnerRacingCarNames.class);
	}

	@Test
	@DisplayName("기준 우승 경주용 자동차가 존재하지 않으면 일급 컬렉션을 생성할 수 없다.")
	void failToCreateWinnerRacingCarNamesIfWinnerRacingCarIsNull() {
		assertThatThrownBy(() -> new WinnerRacingCarNames(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

}