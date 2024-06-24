import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Bookings{
    String passengerName;
    int busno;
    Date date;
   
    Bookings(){
        Scanner sc = new Scanner(System.in) ;
            System.out.println("Enter PassengerName: ");
            passengerName=sc.next();
            System.out.println("Enter BusNo: ");
            busno=sc.nextInt();
            System.out.println("Enter date dd-mm-yyyy");
            String dateInput=sc.next();
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

            try {
                date = dateFormat.parse(dateInput);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    

    public boolean isAvailable() throws SQLException
    {
        BusDAO busdao=new BusDAO();
        int capacity=busdao.getCapacity(busno);

        BookingDAO bookingdao=new BookingDAO();

        int booked=bookingdao.getBookedCount(busno,date);
        

        return booked < capacity ? true : false;
    }
 
}