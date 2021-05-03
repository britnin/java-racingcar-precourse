package racingcar.domain;

public class CarName {

	private final String name;

	public CarName(String name) {
		validate(name);

		this.name = name;
	}

	private void validate(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("자동자 이름이 존재하지 않거나, 길이가 5 이하여야 합니다.");
		}
	}

	@Override
	public String toString() {
		return name;
	}

}
