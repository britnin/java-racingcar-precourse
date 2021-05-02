package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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

	@Test
	@DisplayName("경주용 자동차들은 모두 이동전략에 의해 이동할 수 있다.")
	void moveAllRacingCarsByMovableStrategy() {
		RacingCar racingCar1 = new RacingCar("붕붕이1", () -> true);
		RacingCar racingCar2 = new RacingCar("붕붕이2", () -> false);
		RacingCar racingCar3 = new RacingCar("붕붕이3", () -> true);
		RacingCar racingCar4 = new RacingCar("붕붕이4", () -> false);

		RacingCars racingCars = new RacingCars(Arrays.asList(racingCar1, racingCar2, racingCar3, racingCar4));
		racingCars.moveAll();

		assertThat(racingCar1.compareTo(racingCar2)).isOne();
		assertThat(racingCar3.compareTo(racingCar4)).isOne();
		assertThat(racingCar1.compareTo(racingCar3)).isZero();
		assertThat(racingCar2.compareTo(racingCar4)).isZero();
	}
	
	@Test
	@DisplayName("우승 경주용 자동차 이름 리스트를 얻을 수 있다.")
	void getWinnerRacingCarNames() {
		RacingCars racingCars = new RacingCars(Arrays.asList(new RacingCar("붕붕이1", () -> true),
			new RacingCar("붕붕이2", () -> false), 
			new RacingCar("붕붕이3", () -> true), 
			new RacingCar("붕붕이4", () -> false)));
		
		racingCars.moveAll();
		WinnerRacingCarNames racingCarNames = racingCars.getWinnerRacingCarNames();

		assertThat(racingCarNames).isInstanceOf(WinnerRacingCarNames.class);
		assertThat(racingCarNames.toList().size()).isSameAs(2);
	}

	@Test
	@DisplayName("불변 리스트를 얻을 수 있다.")
	void getUnmodifiableList() {
		RacingCars racingCars = new RacingCars(Arrays.asList(new RacingCar("붕붕이1", () -> true),
			new RacingCar("붕붕이2", () -> false),
			new RacingCar("붕붕이3", () -> true),
			new RacingCar("붕붕이4", () -> false)));

		List<RacingCar> list = racingCars.toList();
		assertThat(list.size()).isSameAs(4);
		assertThatThrownBy(() -> list.add(new RacingCar("붕붕이5", () -> false)))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> list.remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> list.clear())
			.isInstanceOf(UnsupportedOperationException.class);
	}

}