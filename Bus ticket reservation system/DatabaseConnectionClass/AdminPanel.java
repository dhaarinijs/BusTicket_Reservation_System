import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminPanel {
    public boolean addBus(String busNumber,int ac ,int totalSeats,String route) {
        String query = "INSERT INTO buses (bus_number,ac,total_seats,route) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, busNumber);
            stmt.setInt(2, ac);
            stmt.setInt(3,totalSeats);
            stmt.setString(4, route);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteBus(String busNumber) {
        String query = "DELETE FROM buses WHERE bus_number = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, busNumber);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBus(String busNumber, int ac, int totalSeats, String route) {
        String query = "UPDATE buses SET ac = ?, total_seats = ?, route = ? WHERE bus_number = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ac);
            stmt.setInt(2, totalSeats);
            stmt.setString(3, route);
            stmt.setString(4, busNumber);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


