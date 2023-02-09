import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    void ScoreIs0WhenGameStarts() {
        assertEquals(0, new Game().score());
    }

    @Test
    void ScoreIs1WhenRoll1() {
        Game game = new Game();
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void ScoreIs2WhenRoll1And1() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        assertEquals(2, game.score());
    }
}
