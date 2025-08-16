
// --- Standard Assert Test ---
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SplashTest {
    @Test
    void testSplashMainDoesNotThrow() {
        assertDoesNotThrow(() -> Splash.main(new String[]{}));
    }
}
