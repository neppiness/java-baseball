package baseball;

import java.util.ArrayList;
import java.util.List;

public class Prediction {

    public static List<Integer> get() throws IllegalArgumentException {
        String input = InputView.readLine();
        int number = parseInt(input);
        List<Integer> digits = separateDigits(number);
        validate(digits);
        return digits;
    }

    private static int parseInt(String input) { return Integer.parseInt(input); }

    private static List<Integer> separateDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number != 0) {
             digits.add(0, number % 10);
             number /= 10;
        }
        return digits;
    }

    private static void validate(List<Integer> digits) {
        checkIfInputLengthIsThree(digits);
        checkIfDuplicatedDigitsAreUsed(digits);
    }

    private static void checkIfInputLengthIsThree(List<Integer> digits) {
        if (digits.size() != 3)
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
    }

    private static void checkIfDuplicatedDigitsAreUsed(List<Integer> digits) {
        boolean[] isUsed = new boolean[10];
        for (int digit : digits) {
            if (isUsed[digit])
                throw new IllegalArgumentException("중복된 숫자를 사용할 수 없습니다.");
            isUsed[digit] = true;
        }
    }
}
