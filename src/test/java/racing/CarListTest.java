package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.Car;
import racing.car.CarList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

	@Test
	@DisplayName("자동차의 초기 위치는 모두 0 이다")
	void init() {
		int cars = 3;
		CarList carList = new CarList(cars);
		Car[] carListAll = carList.getAll();

		for (Car car : carListAll) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진한다")
	void move_all_cars() {
		int cars = 3;
		CarList carList = new CarList(cars);
		int[] bounds = {4, 5, 6};

		carList.moveAll(bounds);

		for (Car car : carList.getAll()) {
			assertThat(car.getPosition()).isEqualTo(1);
		}

	}
}
