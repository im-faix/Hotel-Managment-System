package personal_project;
import java.io.*;
import java.util.*;

class InformationOfCustomer implements Serializable {
    private String name;
    private long phone;
    private String validId;
    private String roomType;
    private int numDays;
    private double payment;

    public InformationOfCustomer(String name, long phone, String validId, String roomType, int numDays, double payment) {
        this.name = name;
        this.phone = phone;
        this.validId = validId;
        this.roomType = roomType;
        this.numDays = numDays;
        this.payment = payment;
    }

    public String getName() { 
        return name;
     }
    public long getPhone()
     {
         return phone;
         }
    public String getValidId()
     {
         return validId;
     }
    public String getRoomType() { 
        return roomType;
     }
    public int getNumDays()
     {
         return numDays;
     }
    public double getPayment() { 
        return payment; 
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | ID: " + validId + " | Room: " + roomType + " | Days: " + numDays + " | Payment: " + payment;
    }
}

class CustomerManager {
    private static final String FILE_NAME = "ProjectData.txt";
    private List<InformationOfCustomer> customers;

    public CustomerManager() {
        customers = loadCustomers();
    }

    public void addCustomer(InformationOfCustomer customer) {
        customers.add(customer);
        saveCustomers();
    }

    public void removeCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
            saveCustomers();
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i + 1) + ". " + customers.get(i));
            }
        }
    }

    private void saveCustomers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\FILEIO\\ProjectData.txt"))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving customer data.");
        }
    }

    @SuppressWarnings("unchecked")
    private List<InformationOfCustomer> loadCustomers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<InformationOfCustomer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

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
                    System.out.print("Enter Phone (10 digits): ");
                    long phone = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter Valid ID: ");
                    String validId = sc.nextLine();
                    System.out.println("1. Deluxe - 7000/night\n2. Business - 5000/night\n3. General - 3500/night");
                    System.out.print("Choose Room Type: ");
                    int roomChoice = sc.nextInt();
                    System.out.print("Enter Number of Days: ");
                    int numDays = sc.nextInt();

                    String roomType = roomChoice == 1 ? "Deluxe" : roomChoice == 2 ? "Business" : "General";
                    double rate = roomChoice == 1 ? 7000 : roomChoice == 2 ? 5000 : 3500;
                    double payment = rate * numDays;

                    manager.addCustomer(new InformationOfCustomer(name, phone, validId, roomType, numDays, payment));
                    System.out.println("Booking successful!");
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

