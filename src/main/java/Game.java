public class Game {
    private int score;

    public int score() {
        return score;
    }

    public void roll(int i) {
        score+=i;
    }
}
