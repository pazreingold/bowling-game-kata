import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    private List<Integer> rolls = new ArrayList<>();
    ;
    private int rollCounter = 0;

    public int score() {
        return score;
    }

    public void roll(int i) {
        rolls.add(i);
        rollCounter++;
        if (rollCounter > 1 && (rolls.get(rollCounter - 1) + rolls.get(rollCounter - 2) == 10)) {
            score += i * 2;
        } else {
            score += i;
        }

    }
}
