package baseball;

import java.util.List;

public class BaseballGame {

    List<Integer> answer, prediction;
    String executionCode;
    int numberOfBall = 0, numberOfStrike = 0;

    public void run() {
        initialize();
        play();
        end();
        if (isRestartCommand()) run();
    }

    private void initialize() {
        OutputView.guideStart();
        getAnswer();
    }

    private void play() {
        OutputView.guidePredictionInput();
        getPrediction();
        compare();
        if (isWrongPrediction()) play();
    }

    private boolean isWrongPrediction() { return !this.answer.equals(this.prediction); }

    private void end() {
        OutputView.guideEnd();
        OutputView.guideExecutionCode();
        getExecutionCode();
    }

    private void getAnswer() { this.answer = GameMaker.generateAnswer(); }

    private void getPrediction() { this.prediction = Prediction.get(); }

    private void compare() {
        resetNumberOfBallAndStrike();
        getNumberOfBallAndStrike();
        OutputView.printHint(this.numberOfBall, this.numberOfStrike);
    }
    private void resetNumberOfBallAndStrike() {
        this.numberOfBall = 0;
        this.numberOfStrike = 0;
    }

    private void getNumberOfBallAndStrike() {
        countCommonDigits();
        countExactlyMatchedDigits();
    }

    private void countCommonDigits() {
        for (int predictedNumber : this.prediction)
            if (this.answer.contains(predictedNumber)) this.numberOfBall++;
    }

    private void countExactlyMatchedDigits() {
        for (int index = 0; index < this.prediction.size(); index++) {
            int predictedNumberAtIndex = this.prediction.get(index);
            int answerNumberAtIndex = this.answer.get(index);
            if (predictedNumberAtIndex == answerNumberAtIndex) {
                this.numberOfStrike++;
                this.numberOfBall--;
            }
        }
    }

    private void getExecutionCode() { this.executionCode = ExecutionCode.get(); }

    private boolean isRestartCommand() { return this.executionCode.equals("1"); }
}
