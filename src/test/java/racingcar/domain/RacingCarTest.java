package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

	@Test
	@DisplayName("이름을 가진 자동자를 생성할 수 있다.")
	void successToCreateRacingCarWithName() {
		RacingCar car = new RacingCar("테스트");
		assertThat(car.getName()).isEqualTo("테스트");
	}

	@DisplayName("이름이 존재하지 않거나 길이가 5 초과하면 자동차를 생성할 수 없다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "123456" })
	void failToCreateRacingCarIfNameIsNullOrEmptyOrLength5Exceeds(String name) {
		assertThatThrownBy(() -> new RacingCar(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

}