package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerRacingCarNamesTest {

	@Test
	@DisplayName("우승 경주용 자동자 이름 일급 컬렉션을 생성할 수 있다.")
	void successToCreateWinnerRacingCarNames() {
		WinnerRacingCarNames racingCarNames = new WinnerRacingCarNames(new RacingCar(new CarName("붕붕이"), () -> true));
		assertThat(racingCarNames).isInstanceOf(WinnerRacingCarNames.class);
	}

	@Test
	@DisplayName("기준 우승 경주용 자동차가 존재하지 않으면 일급 컬렉션을 생성할 수 없다.")
	void failToCreateWinnerRacingCarNamesIfWinnerRacingCarIsNull() {
		assertThatThrownBy(() -> new WinnerRacingCarNames(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("불변 리스트를 얻을 수 있다.")
	void getUnmodifiableList() {
		WinnerRacingCarNames racingCarNames = new WinnerRacingCarNames(new RacingCar(new CarName("붕붕이1"), () -> true));
		racingCarNames.add(new RacingCar(new CarName("붕붕이2"), () -> true));
		racingCarNames.add(new RacingCar(new CarName("붕붕이3"), () -> true));
		racingCarNames.add(new RacingCar(new CarName("붕붕이4"), () -> true));

		List<CarName> list = racingCarNames.toList();
		assertThat(list.size()).isSameAs(3);
		assertThatThrownBy(() -> list.add(new CarName("붕붕이5")))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> list.remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> list.clear())
			.isInstanceOf(UnsupportedOperationException.class);
	}

}