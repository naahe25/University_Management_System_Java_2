
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class EnterMarksTest {

    @Test
    void testMarksDataPresent() throws Exception {
        Conn c = new Conn();
        String testRoll = "222-134-2610";

        // Insert test data if not already present
        c.s.executeUpdate(
                "INSERT INTO marks (rollno, semester, marks1, marks2, marks3, marks4, marks5) " +
                        "VALUES ('" + testRoll + "', '1', '80', '85', '90', '75', '88')"
        );

        ResultSet rs = c.s.executeQuery(
                "SELECT * FROM marks WHERE rollno='" + testRoll + "'"
        );
        assertTrue(rs.next(), "Marks for rollno " + testRoll + " should exist");

        // Optional: clean up after test
        c.s.executeUpdate("DELETE FROM marks WHERE rollno='" + testRoll + "'");
    }

}