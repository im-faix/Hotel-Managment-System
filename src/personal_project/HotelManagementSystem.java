package personal_project;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();

        while (true) {
            try{
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

                    
                    String validId;  
                    while (true) {
                        System.out.print("Enter Valid ID: ");
                        validId = sc.next();
                        sc.nextLine();
                        if (validId.length() == 10 || validId.length() == 12) break;
                        else
                         System.out.println("Invalid Valid. Try again.");
                    }
                    
                    System.out.println("1. Deluxe - 7000/night\n2. Business - 5000/night\n3. General - 3500/night");
                    System.out.print("Choose Room Type: ");
                    int roomChoice = sc.nextInt();
                    System.out.print("Enter Number of Days: ");
                    int numDays = sc.nextInt();
                    
                    Room room = switch (roomChoice) {
                        case 1 -> new DeluxeRoom();
                        case 2 -> new BusinessRoom();
                        case 3 -> new GeneralRoom();
                        default -> null;
                    };
                    if(room == null)
                    {
                        System.out.println("Invalid Room Choice");
                        continue;
                    }

                    double payment = switch (roomChoice) {
                        case 1 -> 7000 * numDays;
                        case 2 -> 5000 * numDays;
                        case 3 -> 3500 * numDays;
                        default -> 0;
                    };
                    
                    manager.addCustomer(new InformationOfCustomer(name, phone, validId, room, numDays));
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
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
            sc.nextLine();
        }
    }
}

}