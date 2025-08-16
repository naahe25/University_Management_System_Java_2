
// --- Standard Assert Test ---
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ProjectTest {
    @Test
    void testProjectMainDoesNotThrow() {
        assertDoesNotThrow(() -> Project.main(new String[]{}));
    }
}
