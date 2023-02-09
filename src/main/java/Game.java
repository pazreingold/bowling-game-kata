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
        rolls.add(i);
        if (isSpare()) {
            score += i * 2;
        } else {
            score += i;
        }
        rollCounter++;
    }

    private boolean isSpare() {
        return rollCounter > 1 && rollCounter % 2 == 0 && (rolls.get(rollCounter - 1) + rolls.get(rollCounter - 2) == 10);
    }
}
