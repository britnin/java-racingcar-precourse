package racingcar.domain;

import racingcar.domain.strategy.MovableStrategy;

public class RacingCar implements Comparable<RacingCar> {

	private final CarName carName;

	private final MovableStrategy movableStrategy;

	private int position;

	public RacingCar(CarName carName, MovableStrategy movableStrategy) {
		validateCarName(carName);
		validateMovableStrategy(movableStrategy);

		this.carName = carName;
		this.movableStrategy = movableStrategy;
	}

	private void validateCarName(CarName carName) {
		if (carName == null) {
			throw new IllegalArgumentException("자동자 이름이 존재하지 않습니다.");
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

	public CarName getCarName() {
		return carName;
	}

	public int getPosition() {
		return position;
	}

}
