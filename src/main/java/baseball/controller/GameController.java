package baseball.controller;

import baseball.core.GenerateRandom;
import baseball.property.GameCondition;
import baseball.validation.GameValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    public static void playingBaseballGame(GameCondition game_coin){
        while (game_coin.equals(GameCondition.CONTINUE)){
            OutputView.outputForGameValueInputBefore();
            String user_input_value = InputView.readLineByConsole();
            if (GameValidation.verifyForGameValue(user_input_value)){
                OutputView.outputForGameValueInputAfter();
            }
        }
    }
}
