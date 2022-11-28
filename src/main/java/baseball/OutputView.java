package baseball;

public class OutputView {
    public void announceStart() { System.out.println("숫자 야구 게임을 시작합니다."); }

    public void giveHint(int noOfBall, int noOfStrike) {
        StringBuilder stringBuilder = new StringBuilder();
        if(noOfBall > 0) stringBuilder.append(noOfBall).append("볼 ");
        if(noOfStrike > 0) stringBuilder.append(noOfStrike).append("스트라이크");
        if(noOfBall == 0 && noOfStrike == 0) stringBuilder.append("낫싱");
        System.out.println(stringBuilder.toString());
    }

    public void announceEnd() { System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); }

    public void guideExecutionCode() { System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); }
}