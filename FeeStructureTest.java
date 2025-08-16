
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class FeeStructureTest {
    @Test
    void testFeeStructurePresent() throws Exception {
        Conn c = new Conn();
        String course = "CSE"; // example course from your database
        ResultSet rs = c.s.executeQuery("SELECT * FROM fee WHERE course='" + course + "'");
        assertTrue(rs.next(), "Fee structure for course " + course + " should exist");
    }
}

