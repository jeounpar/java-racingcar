package racingcar;

import java.util.List;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomStrategy;

public class RacingGame {

    public static final int FORWARD_CONDITION_LOW_BOUND = 4;
    public static final int MAX_RANDOM_NUMBER = 9;

    private final TryNumber tryNums;
    private final List<String> carNames;
    private MovingStrategy movingStrategy;

    public RacingGame(int tryNums, List<String> names) {
        this.tryNums = new TryNumber(tryNums);
        this.carNames = names;
        this.movingStrategy = new RandomStrategy(FORWARD_CONDITION_LOW_BOUND, MAX_RANDOM_NUMBER);
    }

    public RacingRecord racingStart() {
        RoundCars roundCars = new RoundCars(carNames);
        RacingRecord racingRecord = new RacingRecord();

        for (int round = 0; round < tryNums.getNumber(); round++) {
            RoundCars recordRoundCars = roundCars.moveCars(movingStrategy);
            racingRecord.addCarsPosition(recordRoundCars);
        }

        racingRecord.addWinners(roundCars.retrieveWinners());
        return racingRecord;
    }

    public void changeMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }
}