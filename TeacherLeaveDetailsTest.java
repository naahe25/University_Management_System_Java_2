
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class TeacherLeaveDetailsTest {
    @Test
    void testTeacherLeaveDetailsPresent() throws Exception {
        Conn c = new Conn();
        String empId = "921-8570";
        ResultSet rs = c.s.executeQuery("SELECT * FROM teacherleave WHERE empid='" + empId + "'");
        assertTrue(rs.next(), "Teacher leave details for " + empId + " should exist");
    }
}
