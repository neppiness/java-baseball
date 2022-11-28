package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {
    @DisplayName("giveHint 메소드 정상 출력 테스트1")
    @Test
    void giveHintTest1() {
        OutputView outputView = new OutputView();
        assertSimpleTest(() -> {
                outputView.giveHint(0, 0);
                assertThat(output()).contains("낫싱");
        });
    }

    @DisplayName("giveHint 메소드 정상 출력 테스트2")
    @Test
    void giveHintTest2() {
        OutputView outputView = new OutputView();
        assertSimpleTest(() -> {
            outputView.giveHint(0, 1);
            assertThat(output()).contains("1스트라이크");
        });
    }

    @DisplayName("giveHint 메소드 정상 출력 테스트3")
    @Test
    void giveHintTest3() {
        OutputView outputView = new OutputView();
        assertSimpleTest(() -> {
            outputView.giveHint(3, 0);
            assertThat(output()).contains("3볼");
        });
    }

    @DisplayName("giveHint 메소드 정상 출력 테스트4")
    @Test
    void giveHintTest4() {
        OutputView outputView = new OutputView();
        assertSimpleTest(() -> {
            outputView.giveHint(1, 2);
            assertThat(output()).contains("1볼 2스트라이크");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
