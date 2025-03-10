package personal_project;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();
        double collect ;
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
                        sc.nextLine(); // consume the newline
                        if (String.valueOf(phone).length() == 10) {
                            break;
                        } else {
                            System.out.println("Invalid phone number. Please re-enter a 10-digit phone number.");
                        }
                    }

                    String validId;
                    while (true) {
                        System.out.print("Enter Valid ID (10 or 12 characters): ");
                        validId = sc.nextLine();
                        if (validId.length() == 10 || validId.length() ==12) {
                            break;
                        } else {
                            System.out.println("Invalid ID. Please re-enter a 10-character valid ID.");
                        }
                    }

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

                    InformationOfCustomer customer = new InformationOfCustomer(name, phone, validId, roomType, numDays, payment);
                    manager.addCustomer(customer);
                    // collect = payment*roomChoice;
                    System.out.println("Your Total Payment is " + payment);
                    
                }
                case 2 -> {
                    System.out.println("Listing Customers:");
                    for (int i = 0; i < manager.getCustomerCount(); i++) {
                        InformationOfCustomer customer = manager.getCustomer(i);
                        System.out.println("Customer " + (i + 1) + ": " + customer.getName() + ", Phone: " + customer.getPhone() + ", ID: " + customer.getValidId() + ", Room Type: " + customer.getRoomType() + ", Number of Days: " + customer.getNumDays() + ", Payment: " + customer.getPayment());
                    }
                }
                case 3 -> {
                    System.out.print("Enter customer index to checkout: ");
                    int index = sc.nextInt();
                    sc.nextLine(); // consume the newline
                    InformationOfCustomer customer = manager.getCustomer(index);
                    if (customer != null) {
                        System.out.println("Checking out customer: " + customer.getName());
                        // Implement checkout logic here
                    }
                }
                case 4 -> {
                    System.out.println("Exiting from the Application");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}