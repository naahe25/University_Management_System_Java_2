
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



import java.sql.*;

public class TeacherLeaveTest {

    @Test
    void testAddTeacherLeaveIfNotAlreadyTaken() throws Exception {
        Conn c = new Conn();
        String empId = "921-2644"; // The teacher we want to give leave
        String date = "2025-08-14";
        String duration = "Full Day";

        // Check if this teacher already has leave on this date
        ResultSet rsCheck = c.s.executeQuery(
                "SELECT * FROM teacherleave WHERE empId='" + empId + "' AND date='" + date + "'"
        );

        if (!rsCheck.next()) { // No leave exists
            // Insert leave
            int inserted = c.s.executeUpdate(
                    "INSERT INTO teacherleave(empId, date, duration) VALUES('" + empId + "', '" + date + "', '" + duration + "')"
            );
            assertEquals(1, inserted, "Leave should be added for teacher " + empId);
            System.out.println("Leave added successfully for empId " + empId);
        } else {
            System.out.println("Teacher " + empId + " already has leave on " + date);
        }
    }
}
