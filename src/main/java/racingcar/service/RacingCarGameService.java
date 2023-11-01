package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameService {

    OutputView outputView;

    public RacingCarGameService() {
        outputView = new OutputView();
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void fowardCars(Cars cars){
        List<Car> carsList = cars.getCars();
        for (int i=0;i<carsList.size();++i){
            int number = generateRandomNumber();
            int originStep = carsList.get(i).getStep();
            if(number>=4) carsList.get(i).setStep(originStep+1);
        }
    }

    public void gameRun(int totalRoundNumber, Cars cars){
        for(int i=0;i<totalRoundNumber;++i){
            fowardCars(cars);
            outputView.printRoundResult(cars);
        }
    }

    public int getMaxStep(Cars cars){
        List<Car> carList = cars.getCars();
        int maxStepValue = 0;
        for(int i=0;i<carList.size();++i){
            maxStepValue = Math.max(maxStepValue,carList.get(i).getStep());
        }
        return maxStepValue;
    }

}
