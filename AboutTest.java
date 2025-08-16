
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



import javax.swing.*;

public class AboutTest {
    @Test
    void testWindowComponents() {
        About about = new About();
        assertTrue(about.isVisible());
        boolean found = false;
        for (java.awt.Component comp : about.getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                String text = ((JLabel) comp).getText();
                if (text != null && text.contains("University")) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue(found, "Heading should mention University");
        about.dispose();
    }
}
