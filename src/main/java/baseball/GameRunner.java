package baseball;

import java.util.EnumMap;
import java.util.List;

public class GameRunner {

    enum Type { BALL, STRIKE };
    enum Command { RESTART, END };

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    List<Integer> answer;

    public void run() {
        this.answer = new GameMaker().generateAnswer();
        outputView.announceStart();
        runLoop();

        outputView.announceEnd();
        outputView.guideExecutionCode();
        Command code = inputView.getExecutionCode();
        if(code == Command.RESTART) run();
    }

    public void runLoop() {
        List<Integer> prediction = inputView.getPrediction();
        EnumMap<Type, Integer> numberOf = getComparisonResult(prediction, this.answer);
        outputView.giveHint(numberOf.get(Type.BALL), numberOf.get(Type.STRIKE));
        if(numberOf.get(Type.STRIKE) == 3) return;
        runLoop();
    }

    private EnumMap<Type, Integer> getComparisonResult(List<Integer> prediction, List<Integer> answer) {
        EnumMap<Type, Integer> numberOf = new EnumMap<>(Type.class);
        int noOfBall = 0, noOfStrike = 0;
        for(int index = 0; index < 3; index++) {
            if(prediction.contains(answer.get(index))) noOfBall++;
            if(prediction.get(index).equals(answer.get(index))) {
                noOfBall--;
                noOfStrike++;
            }
        }
        numberOf.put(Type.BALL, noOfBall);
        numberOf.put(Type.STRIKE, noOfStrike);
        return numberOf;
    }
}