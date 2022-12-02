package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class GameMaker {
    public static List<Integer> generateAnswer() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }
}
