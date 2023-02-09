import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void ScoreIs0WhenGameStarts() {
        assertEquals(0, game.score());
    }

    @Test
    void ScoreIs1WhenRoll1() {
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void ScoreIs2WhenRoll1And1() {
        game.roll(1);
        game.roll(1);
        assertEquals(2, game.score());
    }

    @Test
    void ScoreSpare() {
        game.roll(9);
        game.roll(1);
        game.roll(1);
        assertEquals(12, game.score());
    }
}
