import java.sql.SQLException;
import java.util.Scanner;

public class BusDemo {

  public static void main(String[] args) throws SQLException {
    BusDAO busdao = new BusDAO();
    busdao.displayBusInfo();
    UserAuthentication userAuth = new UserAuthentication();
    Scanner sc = new Scanner(System.in);
    boolean loggedIn = false;

    try {
      while (!loggedIn) {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
          System.out.println("Enter username: ");
          String username = sc.nextLine();
          System.out.println("Enter password: ");
          String password = sc.nextLine();
          System.out.println("Enter email: ");
          String email = sc.nextLine();

          if (userAuth.register(username, password, email)) {
            System.out.println("Registration successful.");
          } else {
            System.out.println("Registration failed.");
          }
        } else if (choice == 2) {
          System.out.println("Enter username: ");
          String username = sc.nextLine();
          System.out.println("Enter password: ");
          String password = sc.nextLine();

          if (userAuth.login(username, password)) {
            System.out.println("Login successful.");
            loggedIn = true; 
          } else {
            System.out.println("Login failed.");
          }
        } else if (choice == 3) {
          break;
        } else {
          System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
      }

      while (loggedIn) {
        System.out.println("1. Admin Panel");
        System.out.println("2. Book Ticket");
        System.out.println("3. View Bookings");
        System.out.println("4. Exit");

        int roleChoice = sc.nextInt();
        sc.nextLine();

        if (roleChoice == 1) {
          AdminPanel adminPanel = new AdminPanel();

          System.out.println("1. Add Bus");
          System.out.println("2. Delete Bus");
          System.out.println("3. Update Bus");
          System.out.println("4. View Buses");
          int adminChoice = sc.nextInt();
          sc.nextLine();

          if (adminChoice == 1) {
            System.out.println("Enter bus number: ");
            String busNumber = sc.nextLine();
            System.out.println("Enter Ac Or Non-ac: ");
            int ac = sc.nextInt();
            System.out.println("Enter total seats: ");
            int capacity = sc.nextInt();
            sc.nextLine();
            System.out.println("Bus Route: ");
            String route = sc.nextLine();

            if (adminPanel.addBus(busNumber, ac, capacity, route)) {
              System.out.println("Bus added successfully.");
            } else {
              System.out.println("Failed to add bus.");
            }
          } else if (adminChoice == 2) {
            System.out.println("Enter bus number to delete: ");
            String busNumber = sc.nextLine();

            if (adminPanel.deleteBus(busNumber)) {
              System.out.println("Bus deleted successfully.");
            } else {
              System.out.println("Failed to delete bus.");
            }
          } else if (adminChoice == 3) {
            System.out.println("Enter bus number to update: ");
            String busNumber = sc.nextLine();
            System.out.println("Enter Ac Or Non-ac (0/1): ");
            int ac = sc.nextInt();
            System.out.println("Enter total seats: ");
            int capacity = sc.nextInt();
            sc.nextLine();
            System.out.println("Bus Route: ");
            String route = sc.nextLine();

            if (adminPanel.updateBus(busNumber, ac, capacity, route)) {
              System.out.println("Bus updated successfully.");
            } else {
              System.out.println("Failed to update bus.");
            }
          } else if (adminChoice == 4) {
            busdao.displayBusInfo();
          }
        } else if (roleChoice == 2) {
          while (true) {
            Bookings booking = new Bookings();

            if (booking.isAvailable()) {
              double ticketPrice = 50.0;
              System.out.println("Calculating ticket price...");
              System.out.println("Ticket price: $" + ticketPrice);
              System.out.println("Select payment method:");
              System.out.println("1. Credit/Debit Card");
              System.out.println("2. Online Banking");
             
              int paymentMethod=sc.nextInt(); 
              boolean paymentStatus =false;
               if (paymentMethod == 1)
               {
                PaymentService.processCardPayment(ticketPrice);
                paymentStatus=true;
               }
               else if(paymentMethod==2){
                PaymentService.onlineBankingPayment(ticketPrice);
                paymentStatus=true;
               }
               else {
                        System.out.println("Invalid input. Please enter 1 or 2.");
                    }
  
              if (paymentStatus) {
                BookingDAO bookingdao = new BookingDAO();
                bookingdao.addBooking(booking);
                System.out.println("Your booking is confirmed");
              } 
            }
            else {
                System.out.println("Sorry bus is full. Try another bus or date");
              }

              System.out.println("Enter 1 for another booking or 2 to exit");
              int bookingchoice = sc.nextInt();
              sc.nextLine();
              if (bookingchoice != 1)
                break;
           
          }
        } else if (roleChoice == 3) {
          BookingDAO bookingdao = new BookingDAO();
          System.out.println("Enter UserName: ");
          String name = sc.next();
          bookingdao.viewBookings(name);
        } else if (roleChoice == 4) {
          loggedIn = false; 
          break; 
        } else {
          System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
        }
      }
    }finally

  {
    sc.close();
  }
}}
