package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

	@Test
	@DisplayName("자동자 이름 객체를 생성할 수 있다.")
	void successToCreateCarName() {
		CarName carName = new CarName("테스트");
		assertThat(carName).isInstanceOf(CarName.class);
	}

	@DisplayName("이름이 존재하지 않거나 길이가 5 초과하면 자동차 이름 객체를 생성할 수 없다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "123456" })
	void failToCreateCarNameIfNameIsNullOrEmptyOrLength5Exceeds(String name) {
		assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름 객체를 String 값으로 얻을 수 있다.")
	void getCarNameToString() {
		CarName carName = new CarName("테스트");
		assertThat(carName.toString()).isEqualTo("테스트");
	}

}
