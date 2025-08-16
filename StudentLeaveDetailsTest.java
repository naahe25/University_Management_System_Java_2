
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class StudentLeaveDetailsTest {
    @Test
    void testLeaveDetailsExist() throws Exception {
        Conn c = new Conn();
        String rollno = "222-134-1187";
        ResultSet rs = c.s.executeQuery("SELECT * FROM studentleave WHERE rollno='" + rollno + "'");
        assertTrue(rs.next(), "Student leave details for " + rollno + " should exist");
    }
}
