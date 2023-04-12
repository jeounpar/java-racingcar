package racingcar.model.dto;

import racingcar.model.Racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingDto {
    List<CarDto> cars;
    int currentRound;

    private RacingDto(List<CarDto> cars, int currentRound) {
        this.cars = cars;
        this.currentRound = currentRound;
    }

    public static RacingDto from(Racing racing) {
        List<CarDto> cars = racing.cars()
                .stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
        
        return new RacingDto(cars, racing.currentRound());
    }

    public List<CarDto> cars() {
        return cars;
    }

    public int currentRound() {
        return currentRound;
    }
}