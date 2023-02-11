import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(firstInFrame)) {
                score += 10 + getStrikeBonus(firstInFrame);
                firstInFrame++;
            } else if (isSpare(firstInFrame)) {
                score += 10 + getSpareBonus(firstInFrame);
                firstInFrame += 2;
            } else {
                score += rolls.get(firstInFrame) + rolls.get(firstInFrame + 1);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int firstInFrame) {
        return rolls.get(firstInFrame) == 10;
    }

    private int getStrikeBonus(int firstInFrame) {
        return rolls.get(firstInFrame + 1) + rolls.get(firstInFrame + 2);
    }

    private boolean isSpare(int firstInFrame) {
        return rolls.get(firstInFrame) + rolls.get(firstInFrame + 1) == 10;
    }

    private Integer getSpareBonus(int firstInFrame) {
        return rolls.get(firstInFrame + 2);
    }
}
