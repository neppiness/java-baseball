package baseball;

public class OutputView {

    public static void guideStart() { System.out.println("숫자 야구 게임을 시작합니다."); }
    public static void guideEnd() { System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); }

    public static void guidePredictionInput() { System.out.print("숫자를 입력해주세요 : "); }
    public static void guideExecutionCode() { System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); }

    public static void printHint(int numberOfBall, int numberOfStrike) {
        if (numberOfBall > 0) System.out.printf("%d볼 ", numberOfBall);
        if (numberOfStrike > 0) System.out.printf("%d스트라이크", numberOfStrike);
        if (numberOfBall == 0 && numberOfStrike == 0) System.out.print("낫싱");
        System.out.println();
    }
}
