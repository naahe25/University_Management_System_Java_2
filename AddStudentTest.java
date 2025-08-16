
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

// --- Parameterized Test (@ValueSource) ---
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// --- Parameterized Test (@MethodSource) ---
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

// --- Mockito Test ---
import org.mockito.Mockito;



public class AddStudentTest {

    private final String testName = "Test Student " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        // Delete all test entries
        c.s.executeUpdate("DELETE FROM student WHERE name='" + testName + "'");
        c.s.executeUpdate("DELETE FROM student WHERE name IN ('Alice','Bob','Charlie','Daniel','Eve','Frank')");
    }

    // Standard Assert Test
    @Test
    void testAddStudentEntry() throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fname, rollno, dob, address, phone, email, nid, sscgpa, hscgpa, course, batch) VALUES (" +
                "'" + testName + "', 'Father Name', 'R123', '2000-01-01', 'Address', '1234567890', 'test@student.com','123456789', '4.5', '4.0', 'CS', '20th Batch')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count, "Insert should affect 1 row");

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + testName + "'");
        assertTrue(rs.next(), "Student entry should exist in DB after insert");
        assertEquals(testName, rs.getString("name"));
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"Alice", "Bob", "Charlie"})
    void testAddStudentValueSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fname, rollno, dob, address, phone, email, nid, sscgpa, hscgpa, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', 'R" + System.currentTimeMillis() + "', '2000-01-01', 'Address', '1234567890', 'test1@student.com','1234567893', '4.5', '4.0', 'CS', '20th Batch')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> studentNameProvider() {
        return Stream.of("Daniel", "Eve", "Frank");
    }

    @ParameterizedTest
    @MethodSource("studentNameProvider")
    void testAddStudentMethodSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fname, rollno, dob, address, phone, email, nid, sscgpa, hscgpa, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', 'R" + System.currentTimeMillis() + "', '2000-01-01', 'Address', '1234567890', 'test2@student.com','1234567894', '4.5', '4.0', 'CS', '20th Batch')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
    }

    // Mockito Test (works with Java 17+ without JVM flags)
    @Test
    void testAddStudentWithMockedStatement() throws Exception {
        // Mock Statement only
        Statement mockStatement = Mockito.mock(Statement.class);
        Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);

        // Create a fake Conn using the mocked statement
        Conn fakeConn = new Conn() {
            { s = mockStatement; }
        };

        int count = fakeConn.s.executeUpdate("INSERT INTO student ...");
        assertEquals(1, count);

        // Verify that executeUpdate was called exactly once
        Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate(Mockito.anyString());
    }
}
