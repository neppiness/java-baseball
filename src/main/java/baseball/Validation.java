package baseball;

public class Validation {

    enum Type {
        PREDICTION(3),
        EXECUTIONCODE(1);

        private final int length;
        Type(int length) { this.length = length; }
    };

    void isInputLengthIsCorrect(String lineInput, Type type) {
        if(lineInput.length() == type.length) return;
        throw new IllegalArgumentException(String.format("숫자를 %d개 입력해주세요.", type.length));
    }

    void isNumber(char charAtIndex) {
        if(charAtIndex >= '1' && charAtIndex <= '9') return;
        throw new IllegalArgumentException("자연수만 입력해주세요.");
    }

    void isInputNumber(String lineInput) {
        for(int index = 0; index < lineInput.length(); index++) {
            char charAtIndex = lineInput.charAt(index);
            isNumber(charAtIndex);
        }
    }

    void isDuplicated(String lineInput) {
        boolean[] usedNumber = new boolean[10];
        for (int index = 0; index < lineInput.length(); index++) {
            char charAtIndex = lineInput.charAt(index);
            int number = charAtIndex - '0';
            if(usedNumber[number])
                throw new IllegalArgumentException("숫자를 중복해서 쓸 수 없습니다.");
            usedNumber[number] = true;
        }
    }

    void prediction(String lineInput) {
        isInputLengthIsCorrect(lineInput, Type.PREDICTION);
        isInputNumber(lineInput);
        isDuplicated(lineInput);
    }

    void isInputOneOrTwo(String lineInput) {
        if(lineInput.charAt(0) == '1' || lineInput.charAt(0) == '2') return;
        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }

    void executionCode(String lineInput) {
        isInputLengthIsCorrect(lineInput, Type.EXECUTIONCODE);
        isInputOneOrTwo(lineInput);
    }
}