
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



public class AddTeacherTest {

    private final String testName = "Test Teacher " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        // Remove test entries from your database
        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + testName + "'");
        c.s.executeUpdate("DELETE FROM teacher WHERE name IN ('Dr. Smith','Prof. Johnson','Ms. Clark','Mr. Lee','Mrs. Evans','Dr. Patel')");
    }

    // Standard Assert Test
    @Test
    void testAddTeacherEntry() throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fname, empId, dob, address, phone, email, nid, sscgpa, hscgpa, education, department) VALUES (" +
                "'" + testName + "', 'Father Name', 'EMP" + System.currentTimeMillis() + "', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', '1234567890', '5.0', '5.0', 'MSc', 'Math')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + testName + "'");
        assertTrue(rs.next());
        assertEquals(testName, rs.getString("name"));
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"Dr. Smith", "Prof. Johnson", "Ms. Clark"})
    void testAddTeacherValueSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fname, empId, dob, address, phone, email, nid, sscgpa, hscgpa, education, department) VALUES (" +
                "'" + name + "', 'Father Name', 'EMP" + System.currentTimeMillis() + "', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', '1234567890', '5.0', '5.0', 'MSc', 'Math')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));

        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + name + "'");
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> teacherNameProvider() {
        return Stream.of("Mr. Lee", "Mrs. Evans", "Dr. Patel");
    }

    @ParameterizedTest
    @MethodSource("teacherNameProvider")
    void testAddTeacherMethodSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fname, empId, dob, address, phone, email, nid, sscgpa, hscgpa, education, department) VALUES (" +
                "'" + name + "', 'Father Name', 'EMP" + System.currentTimeMillis() + "', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', '1234567890', '5.0', '5.0', 'MSc', 'Math')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));

        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + name + "'");
    }

    // Mockito Test
    @Test
    void testAddTeacherWithMockedConn() throws Exception {
        // Mock Statement
        Statement mockStatement = Mockito.mock(Statement.class);
        Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);

        // Mock Conn
        Conn mockConn = new Conn() {
            { s = mockStatement; }
        };

        int count = mockConn.s.executeUpdate("INSERT INTO teacher ...");
        assertEquals(1, count);

        Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate(Mockito.anyString());
    }
}
