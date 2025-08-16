
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class ExaminationDetailsTest {
    @Test
    void testExaminationDataPresent() throws Exception {
        Conn c = new Conn();
        String examId = "JUNIT-EXAM";
        ResultSet rs = c.s.executeQuery("SELECT * FROM examination WHERE exam_id='" + examId + "'");
        assertTrue(rs.next(), "Examination with exam_id " + examId + " should exist");
    }
}
