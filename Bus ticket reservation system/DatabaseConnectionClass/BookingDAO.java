import java.sql.*;
import java.util.Date;


public class BookingDAO {
    public int getBookedCount(int busno,Date date) throws SQLException{

        String query="Select count(passenger_name) from bookings where bus_no=? and booking_date=?";
        Connection con=DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate= new java.sql.Date(date.getTime());
        pst.setInt(1, busno);
        pst.setDate(2, sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Bookings booking) throws SQLException{
        String query="Insert into bookings values(?,?,?)";
        Connection con=DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busno);
        java.sql.Date sqldate= new java.sql.Date(booking.date.getTime());
        pst.setDate(3, sqldate);

        pst.executeUpdate();
    
    }
    public void viewBookings(String username) throws SQLException {
        String query="Select * from bookings where passenger_name=?";
        
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setString(1, username);
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
        System.out.println("PassengerName: "+rs.getString(1));
        System.out.println("BusNo: "+rs.getInt(2));
        System.out.println("Travel Date: " +rs.getString(3));
        }
           
        } 


}
