
// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// --- Mockito Test ---
import org.mockito.Mockito;



import java.sql.Connection;
import java.sql.Statement;

public class ConnTest {

    // Standard Assert Test
    @Test
    void testConnectionAndStatement() {
        Conn conn = new Conn();
        assertNotNull(conn.c, "Connection should be established");
        assertNotNull(conn.s, "Statement should be created");
    }

    // Mockito Test
    @Test
    void testConnWithMockedConnection() {
        Connection mockConnection = Mockito.mock(Connection.class);
        Statement mockStatement = Mockito.mock(Statement.class);

        Conn conn = Mockito.mock(Conn.class);
        conn.c = mockConnection;
        conn.s = mockStatement;

        assertNotNull(conn.c);
        assertNotNull(conn.s);
    }
}
