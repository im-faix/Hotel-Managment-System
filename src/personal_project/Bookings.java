package personal_project;

import java.util.Scanner;

public class Bookings
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome To Our Hotel");
        System.out.println("=".repeat(50));
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Adding the customer/lending rooms\n2.Checking out of the customer \n3.Exit");
            System.out.println("Enter you Choice");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                      System.out.println("Collect their Details");
                      CollectingDetails.addingDetails();
                      break;
                
                case 2:
                    System.out.println("Thanks and visit again");
                    CustomerManager cs = new CustomerManager();
                    System.out.println(cs.getCustomerCount());
                    break;
                case 3:
                     System.exit(0);
                default:
                      System.out.println("Please Provide  a Valid Choice");
                      break;
            }

        }
        
            
    }
}