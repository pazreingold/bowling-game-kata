import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    private final List<Integer> rolls = new ArrayList<>();
    private int rollCounter = 0;

    public int score() {
        return score;
    }

    public void roll(int i) {
        validateGameIsOver();

        rolls.add(i);

        if (isStrike(i)) {
            rollCounter++;
            rolls.add(0);
        }

        score += calculateScore(i);

        rollCounter++;
    }

    private void validateGameIsOver() {
        if (!ShouldDoubleScoreInFirstRoll() && rolls.size() > 19 || rolls.size() > 20) {
            throw new IllegalStateException("Game is Over");
        }
    }

    private int calculateScore(int i) {
        return ShouldDoubleScoreInFirstRoll() || shouldDoubleScoreInSecondRoll() ? i * 2 : i;
    }

    private boolean ShouldDoubleScoreInFirstRoll() {
        return rollCounter > 1 && isFirstRollInFrame() && hadSpare();
    }

    private boolean shouldDoubleScoreInSecondRoll() {
        return rollCounter > 1 && isSecondRollInFrame() && rolls.get(rollCounter - 3) == 10 && rollCounter < 21;
    }

    private boolean hadSpare() {
        return rolls.get(rollCounter - 1) + rolls.get(rollCounter - 2) == 10;
    }

    private boolean isStrike(int i) {
        return i == 10 && isFirstRollInFrame();
    }

    private boolean isFirstRollInFrame() {
        return rollCounter % 2 == 0;
    }

    private boolean isSecondRollInFrame() {
        return rollCounter % 2 == 1;
    }
}
