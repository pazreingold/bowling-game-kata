import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    private void rollMany(int rolls, int pins) {
        IntStream
                .iterate(1, i -> i + 1)
                .limit(rolls)
                .forEach(i -> game.roll(pins));
    }

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void allZeros() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    void allOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    void oneSpare() {
        game.roll(9);
        game.roll(1);
        game.roll(1);
        rollMany(17, 0);
        assertEquals(12, game.score());
    }

    @Test
    void oneStrike() {
        game.roll(10);
        game.roll(1);
        game.roll(1);
        rollMany(16, 0);
        assertEquals(14, game.score());
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
