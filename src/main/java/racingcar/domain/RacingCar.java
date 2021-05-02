package racingcar.domain;

import racingcar.domain.strategy.MovableStrategy;

public class RacingCar implements Comparable<RacingCar> {

	private final String name;

	private final MovableStrategy movableStrategy;

	private int position;

	public RacingCar(String name, MovableStrategy movableStrategy) {
		validateName(name);
		validateMovableStrategy(movableStrategy);

		this.name = name;
		this.movableStrategy = movableStrategy;
	}

	private void validateName(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("자동자 이름이 존재하지 않거나, 길이가 5 이하여야 합니다.");
		}
	}

	private void validateMovableStrategy(MovableStrategy movableStrategy) {
		if (movableStrategy == null) {
			throw new IllegalArgumentException("이동 전략이 존재하지 않습니다.");
		}
	}

	public void move() {
		if (movableStrategy.isMovable()) {
			position++;
		}
	}

	@Override
	public int compareTo(RacingCar o) {
		return o.comparePosition(position);
	}

	private int comparePosition(int otherPosition) {
		return otherPosition - position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}
