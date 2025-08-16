
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

// --- Parameterized Test (@ValueSource) ---
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// --- MethodSource ---
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

// --- Mockito Test ---
import org.mockito.Mockito;



public class MarksTest {

    // Standard Assert Test
    @Test
    void testMarksExistForStudent() throws Exception {
        Conn c = new Conn();
        String testRoll = "222-134-1187";
        ResultSet rs = c.s.executeQuery("SELECT * FROM marks WHERE rollno='" + testRoll + "'");
        assertTrue(rs.next(), "Marks for rollno " + testRoll + " should exist");
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"222-134-1187", "222-134-1643"})
    void testMarksExistValueSource(String rollno) throws Exception {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("SELECT * FROM marks WHERE rollno='" + rollno + "'");
        assertTrue(rs.next());
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> rollProvider() {
        return Stream.of("222-134-1187", "222-134-1643");
    }

    @ParameterizedTest
    @MethodSource("rollProvider")
    void testMarksExistMethodSource(String rollno) throws Exception {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("SELECT * FROM marks WHERE rollno='" + rollno + "'");
        assertTrue(rs.next());
    }

    // Mockito Test
    @Test
    void testMarksWithMockedConn() throws Exception {
        Statement mockStatement = Mockito.mock(Statement.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockStatement.executeQuery(Mockito.anyString())).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true);

        Conn mockConn = Mockito.mock(Conn.class);
        mockConn.s = mockStatement;
        ResultSet rs = mockConn.s.executeQuery("SELECT * FROM marks WHERE rollno='222-134-7777'");
        assertTrue(rs.next());
    }
}
