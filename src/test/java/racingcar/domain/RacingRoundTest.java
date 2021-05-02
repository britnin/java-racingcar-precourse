package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingRoundTest {

	@Test
	@DisplayName("0보다 클 경우 이동횟수 포장 클래스를 생성할 수 있다.")
	void successToCreateRacingRoundIfGreaterThan0() {
		RacingRound racingRound = new RacingRound(1);
		assertThat(racingRound).isInstanceOf(RacingRound.class);
	}

	@Test
	@DisplayName("이동횟수가 0보다 작거나 같을 경우 생성할 수 없다.")
	void failToCreateRacingRoundIfLessThanOrEqualTo0() {
		assertThatThrownBy(() -> new RacingRound(0))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이동횟수만큼 반복문 실행이 가능하다.")
	void callHasNextAsManyRoundValue() {
		int round = 0;
		RacingRound racingRound = new RacingRound(5);

		while (racingRound.hasNext()) {
			round++;
		}

		assertThat(round).isSameAs(5);
	}

}