import java.util.Scanner;

public class PaymentService {
    
    public static void processCardPayment(double amount) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter card number: ");
        String cardNumber = sc.nextLine();
        System.out.println("Enter expiry date (MM/YYYY): ");
        String expiryDate = sc.nextLine();
        System.out.println("Enter CVV: ");
        String cvv = sc.nextLine();
        System.out.println("Payment successful");
    }

    public static void onlineBankingPayment(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bank account number: ");
        String accno = sc.nextLine();
        System.out.println("Enter the amount: ");
        double price = sc.nextDouble();
        System.out.println("Payment successful");
    }
}
