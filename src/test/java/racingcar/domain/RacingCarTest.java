package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

	@Test
	@DisplayName("이름을 가진 자동자를 생성할 수 있다.")
	void successToCreateRacingCarWithName() {
		RacingCar car = new RacingCar("테스트");
		assertThat(car.getName()).isEqualTo("테스트");
	}

}