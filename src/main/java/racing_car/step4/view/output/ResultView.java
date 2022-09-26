package racing_car.step4.view.output;

import racing_car.step4.domain.Cars;
import racing_car.step4.domain.Referee;
import racing_car.step4.dto.CarDTO;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String BAR = "-";
    private static final String COLON = " : ";
    
    public static void resultMessagePrint() {
        System.out.println(RESULT_MESSAGE);
    }
    
    public static void processPrint(Cars cars) {
        List<CarDTO> carDTOs = cars.information();
        
        for (CarDTO carDTO : carDTOs) {
            System.out.print(carDTO.getCarName() + COLON);
            processBarPrint(carDTO.getPosition());
        }
        System.out.println();
    }
    
    private static void processBarPrint(int position) {
        while (position-- > 0) {
            System.out.print(BAR);
        }
        System.out.println();
    }
    
    public static void winnersPrint(Referee referee) {
        System.out.println(String.join(", ", referee.getWinnersName()) + "가 최종 우승했습니다.");
    }
}