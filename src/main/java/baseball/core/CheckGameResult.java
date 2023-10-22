package baseball.core;

import baseball.property.GameScore;

public class CheckGameResult {

    public static void checkGameScore(GameScore gameScore){
        int ball_count = gameScore.getBall_count();
        int strike_count = gameScore.getStrike_count();
        if (checkScoreExist(ball_count,strike_count)){
            if (checkBallAndStrikeScore(ball_count,strike_count)){
                ResultOutputGenerate.generateAllResultTextForOutput(ball_count,strike_count);
                return;
            }
            checkOneTypeScore(ball_count,strike_count);
        }
    }

    private static boolean checkScoreExist(int ball_count,int strike_count){
        if (checkScoreIsNothing(ball_count,strike_count)){
            ResultOutputGenerate.generateNothingResultTextForOutput();
            return false;
        }
        return true;
    }

    private static boolean checkBallScore(int ball_count){
        return ball_count>0;
    }

    private static boolean checkStrikeScore(int strike_count){
        return strike_count>0;
    }

    private static boolean checkGameSuccessCondition(int strike_count){
        return strike_count == 3;
    }

    private static void checkOneTypeScore(int ball_count,int strike_count){
        if(checkOnlyStrikeScore(ball_count,strike_count)){
            if (checkGameSuccessCondition(strike_count)){
                ResultOutputGenerate.generateSuccessResultTextForOutput();
                return;
            }
            ResultOutputGenerate.generateStrikeResultTextForOutput(strike_count);
            return;
        }
        ResultOutputGenerate.generateBallResultTextForOutput(ball_count);
    }

    private static boolean checkOnlyStrikeScore(int ball_count,int strike_count){
        return !checkBallScore(ball_count) && checkStrikeScore(strike_count);
    }

    private static boolean checkBallAndStrikeScore(int ball_count,int strike_count){
        return checkBallScore(ball_count) && checkStrikeScore(strike_count);
    }

    private static boolean checkScoreIsNothing(int ball_count,int strike_count){
        return ball_count == 0 && strike_count == 0;
    }
}
