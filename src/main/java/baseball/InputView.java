package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final Validation validation = new Validation();

    public String getLine() { return Console.readLine(); }

    private List<Integer> separateDigits(String lineInput) {
        List<Integer> digits = new ArrayList<>();
        int inputAsNumber = Integer.parseInt(lineInput);
        while (inputAsNumber != 0) {
            digits.add(0, inputAsNumber % 10);
            inputAsNumber /= 10;
        }
        return digits;
    }

    public List<Integer> getPrediction() {
        String lineInput = getLine();
        validation.prediction(lineInput);
        return separateDigits(lineInput);
    }

    public GameRunner.Command getExecutionCode() {
        String lineInput = getLine();
        validation.executionCode(lineInput);
        if(lineInput.equals("1")) return GameRunner.Command.RESTART;
        return GameRunner.Command.END;
    }
}