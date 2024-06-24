import java.sql.*;

public class BusDAO {
    public void displayBusInfo() throws SQLException{
       String query="Select * from buses";
       Connection con=DBConnection.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(query);

       while(rs.next())
       {
        System.out.println("BusNo: "+rs.getInt(2));
        if(rs.getInt(3)==0)
        {
            System.out.println("AC: No ");
        }
        else{
            System.out.println("AC: Yes");
        }
        System.out.println("Total Capacity: "+rs.getInt(4));
        System.out.println("Bus Route: "+ rs.getString(5));
        System.out.println("----------------------------------------------------");
       }
       
    }

    public int getCapacity(int id) throws SQLException{
        String query="Select total_seats from buses where bus_number= "+id;
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
