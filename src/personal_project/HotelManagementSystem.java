package personal_project;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();

        while (true) {
            System.out.println("\n1. Add Customer\n2. List Customers\n3. Checkout Customer\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    
                    long phone;
                    while (true) {
                        System.out.print("Enter Phone (10 digits): ");
                        phone = sc.nextLong();
                        sc.nextLine();
                        if (String.valueOf(phone).length() == 10) break;
                        System.out.println("Invalid phone number. Try again.");
                    }

                    System.out.print("Enter Valid ID: ");
                    String validId = sc.nextLine();
                    
                    System.out.println("1. Deluxe - 7000/night\n2. Business - 5000/night\n3. General - 3500/night");
                    System.out.print("Choose Room Type: ");
                    int roomChoice = sc.nextInt();
                    System.out.print("Enter Number of Days: ");
                    int numDays = sc.nextInt();
                    
                    String roomType = switch (roomChoice) {
                        case 1 -> "Deluxe";
                        case 2 -> "Business";
                        case 3 -> "General";
                        default -> "Unknown";
                    };

                    double payment = switch (roomChoice) {
                        case 1 -> 7000 * numDays;
                        case 2 -> 5000 * numDays;
                        case 3 -> 3500 * numDays;
                        default -> 0;
                    };
                    
                    manager.addCustomer(new InformationOfCustomer(name, phone, validId, roomType, numDays, payment));
                    System.out.println("Booking successful! Total Payment: " + payment);
                }
                case 2 -> manager.listCustomers();
                case 3 -> {
                    manager.listCustomers();
                    System.out.print("Enter Customer Number to Checkout: ");
                    int index = sc.nextInt() - 1;
                    manager.removeCustomer(index);
                    System.out.println("Customer checked out.");
                }
                case 4 -> {
                    System.out.println("Thank you for using Hotel Management System!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}