package baseball;

public class ExecutionCode {

    public static String get() throws IllegalArgumentException {
        String input = InputView.readLine();
        validate(input);
        return input;
    }

    private static void validate(String input) {
        String[] correctInputs = new String[]{"1", "2"};
        for (String correctInput : correctInputs)
            if (input.equals(correctInput)) return;
        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }
}
