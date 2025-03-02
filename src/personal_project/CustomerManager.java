package personal_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
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

    public InformationOfCustomer getCustomer(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    public int getCustomerCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerCount'");
    }
}
