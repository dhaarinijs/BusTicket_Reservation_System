import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthentication {

    public boolean register(String username, String password, String email) throws SQLException {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            return stmt.executeUpdate()>0;
        
}

public boolean login(String username, String password) throws SQLException {
    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); 

}
}