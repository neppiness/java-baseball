import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
//package baseball;

public class Application {
    public static ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber))
                answer.add(randomNumber);
        }
        return answer;
    }

    public static boolean isCorrectLength(String consoleInput) { return (consoleInput.length() == 3); }

    public static boolean isInt(String consoleInput) {
        char charInString;
        for (int index = 0; index < consoleInput.length(); index++) {
            charInString = consoleInput.charAt(index);
            if (charInString < '1' || charInString > '9')
                return false;
        }
        return true;
    }

    public static boolean isDigitDuplicated(String consoleInput) {
        boolean[] isUsed = new boolean[10];
        for (int digit = 1; digit < 10; digit++)
            isUsed[digit] = false;

        char charInString;
        int digit;
        for (int index = 0; index < consoleInput.length(); index++) {
            charInString = consoleInput.charAt(index);
            digit = (int)(charInString - '0');
            if(isUsed[digit]) return false;
            isUsed[digit] = true;
        }
        return true;
    }

    public static void validateInput(String consoleInput) {
        if (!isCorrectLength(consoleInput) || !isInt(consoleInput)) {
            throw new IllegalArgumentException("Input should be 3-digit integer");
        } else if (!isDigitDuplicated(consoleInput)) {
            throw new IllegalArgumentException("Input should consist of non-duplicated digits");
        }
    }

    public static ArrayList<Integer> separateDigit(int inputNumber) {
        ArrayList<Integer> digitArray = new ArrayList<>();
        int temp = inputNumber, remainder;
        while (temp != 0) {
            remainder = temp % 10;
            digitArray.add(0, remainder);
            temp /= 10;
        }
        return digitArray;
    }

    public static void predictNumber(ArrayList<Integer> answer) {
        ArrayList<Integer> prediction = new ArrayList<>();
        String consoleInput;
        while (!answer.equals(prediction)) {
            System.out.print("숫자를 입력해주세요 : ");
            consoleInput = Console.readLine();
            validateInput(consoleInput);

            int inputNumber = Integer.parseInt(consoleInput);
            prediction = separateDigit(inputNumber);
            // TODO: implement method, printHint(answer, prediction);
        }
    }

    public static void main(String[] args) throws Exception {
        int executionCode = 1;
        ArrayList<Integer> answer;
        while (executionCode == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            answer = generateAnswer();

            System.out.println(answer);

            predictNumber(answer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            executionCode = Integer.parseInt(Console.readLine());
        }
    }
}