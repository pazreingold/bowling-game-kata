import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    void ScoreIs0WhenGameStarts() {
        assertEquals(0, new Game().score());
    }
}
