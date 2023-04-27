package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.StopNumberStrategy;

class CarsTest {

  Cars cars;
  private static final int CAR_NUMBER = 3;
  private static final int TRY_NUMBER = 5;

  @BeforeEach
  public void init() {
    cars = new Cars("pobi,crong,honux");
  }

  @Test
  void 우승자는0명일수없다() {
    for (int i = 0; i < TRY_NUMBER; i++) {
      cars.tryMove();
    }
    Winners winners = cars.findWinner();

    assertThat(winners.getWinnerCars().size()).isGreaterThan(0);
  }

  @Test
  void 우승자한명구하기() {
    Car yeCar = new Car("yecar", new MoveNumberStrategy());
    yeCar.move();
    yeCar.move();
    yeCar.move();
    Car juCar = new Car("jucar", new StopNumberStrategy());
    juCar.move();
    Cars cars = new Cars(Arrays.asList(yeCar, juCar));

    Winners winners = cars.findWinner();

    assertThat(winners.getWinnerCars()).contains(yeCar);
  }

  @Test
  void 우승자두명구하기() {
    Car yeCar = new Car("yecar", new MoveNumberStrategy());
    yeCar.move();
    yeCar.move();
    yeCar.move();
    Car juCar = new Car("jucar", new MoveNumberStrategy());
    juCar.move();
    juCar.move();
    juCar.move();
    Car siCar = new Car("sicar", new StopNumberStrategy());
    siCar.move();
    siCar.move();
    Cars cars = new Cars(Arrays.asList(yeCar, juCar, siCar));

    Winners winners = cars.findWinner();

    assertThat(winners.getWinnerCars()).contains(yeCar);
    assertThat(winners.getWinnerCars()).contains(juCar);
  }

  @Test
  void 이동횟수는음수를입력할수없다() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> new TryNumber(-1));
  }

  @Test
  void 자동차생성할수있다() {
    assertThat(cars.getGameCars().size()).isEqualTo(CAR_NUMBER);
  }

}