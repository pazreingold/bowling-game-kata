import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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

    @Test
    void ScoreSpareInAFrame() {
        game.roll(1);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        assertEquals(12, game.score());
    }

    @Test
    void ScoreStrike() {
        game.roll(10);
        game.roll(1);
        game.roll(1);
        assertEquals(14, game.score());
    }

    @Test
    void ScoreHalfGameWithSpareAndStrikes() {
        game.roll(10);

        game.roll(1);
        game.roll(1);

        game.roll(0);
        game.roll(10);

        game.roll(1);
        game.roll(1);

        game.roll(10);
        assertEquals(37, game.score());
    }

    @Test
    void GameIsNoMoreThan20Rolls() {
        IntStream.iterate(1, i -> i + 1).limit(20)
                .forEach(i -> game.roll(0));
        Exception exception = assertThrows(IllegalStateException.class, () -> game.roll(0));
        assertEquals("Game is Over", exception.getMessage());
    }
}
