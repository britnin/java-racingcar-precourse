package racingcar.domain;

public class RacingCar {

	private final String name;

	public RacingCar(String name) {
		validateName(name);

		this.name = name;
	}

	private void validateName(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("자동자 이름이 존재하지 않거나, 길이가 5 이하여야 합니다.");
		}
	}

	public String getName() {
		return name;
	}

}
