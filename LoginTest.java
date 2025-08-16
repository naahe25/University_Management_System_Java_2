
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;

// --- Parameterized Test (@ValueSource) ---
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// --- Parameterized Test (@MethodSource) ---
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

// --- Mockito Test ---
import org.mockito.Mockito;


import java.sql.Statement;

public class LoginTest {

    // Standard Assert Test
    @Test
    void testAdminLoginSuccess() throws Exception {
        String username = "admin";
        String password = "12345";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        assertTrue(rs.next(), "Login should succeed for admin with correct password");
    }

    @Test
    void testAdminLoginFailure() throws Exception {
        String username = "admin";
        String password = "wrongpassword";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        assertFalse(rs.next(), "Login should fail for admin with incorrect password");
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"admin", "user1", "user2"})
    void testLoginUsers(String username) throws Exception {
        String password = "12345";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        // Only admin should succeed, others should fail (unless DB contains users)
        if ("admin".equals(username)) {
            assertTrue(rs.next());
        } else {
            assertFalse(rs.next());
        }
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> passwordProvider() {
        return Stream.of("12345", "wrongpass", "test123");
    }

    @ParameterizedTest
    @MethodSource("passwordProvider")
    void testAdminLoginWithPasswords(String password) throws Exception {
        String username = "admin";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        if ("12345".equals(password)) {
            assertTrue(rs.next());
        } else {
            assertFalse(rs.next());
        }
    }

    // Mockito Test
    @Test
    void testLoginWithMockedStatement() throws Exception {
        Statement mockStatement = Mockito.mock(Statement.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        Mockito.when(mockStatement.executeQuery(Mockito.anyString())).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true);

        Conn mockConn = Mockito.mock(Conn.class);
        mockConn.s = mockStatement;
        ResultSet rs = mockConn.s.executeQuery("select * from login where username='admin' and password='12345'");
        assertTrue(rs.next());
    }
}
