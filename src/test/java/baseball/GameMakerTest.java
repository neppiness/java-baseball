package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameMakerTest {
    @DisplayName("GameMaker Class 정상 작동 확인")
    @Test
    void 정상_동작_확인() {
        GameMaker gameMaker = new GameMaker();
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> answer = gameMaker.generateAnswer();
                    assertThat(answer).isEqualTo(List.of(1, 3, 5));
                },
                1, 3, 5
        );
    }
}
