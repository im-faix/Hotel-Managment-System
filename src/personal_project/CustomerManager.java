package personal_project;
import java.util.*;

class CustomerManager {
    private List<InformationOfCustomer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    public void addCustomer(InformationOfCustomer customer) {
        customers.add(customer);
    }

    public void removeCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
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
    
    public int getCustomerCount() {
        return customers.size();
    }

    public InformationOfCustomer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }
}