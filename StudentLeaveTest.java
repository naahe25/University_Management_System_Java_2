
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class StudentLeaveTest {

    private final String testRoll = "222-134-8755"; // Choose a roll number not in the table
    private final String testDate = "Aug 14, 2025";
    private final String testDuration = "Full Day";

    @AfterEach
    void cleanUp() throws Exception {
        Conn c = new Conn();
        c.s.executeUpdate("DELETE FROM studentleave WHERE rollno='" + testRoll + "' AND date='" + testDate + "'");
    }

    @Test
    void testStudentLeaveInsertion() throws Exception {
        Conn c = new Conn();

        // Insert a leave record dynamically
        String insertQuery = "INSERT INTO studentleave (rollno, date, duration) VALUES ('"
                + testRoll + "', '" + testDate + "', '" + testDuration + "')";
        int rows = c.s.executeUpdate(insertQuery);
        assertEquals(1, rows, "Leave record should be inserted successfully");

        // Verify that the record exists
        ResultSet rs = c.s.executeQuery(
                "SELECT * FROM studentleave WHERE rollno='" + testRoll + "' AND date='" + testDate + "'"
        );

        assertTrue(rs.next(), "Student leave for " + testRoll + " on " + testDate + " should exist");
        assertEquals(testDuration, rs.getString("duration"), "Duration should match the inserted value");
    }
}
