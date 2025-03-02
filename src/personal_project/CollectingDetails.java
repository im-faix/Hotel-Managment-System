package personal_project;

import java.util.Scanner;

public class CollectingDetails {
    public static void addingDetails()
    {
        int numdays=0;
        double payment =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("3 Types of Rooms");
        System.out.println("1.Delux Rooms \t\t7000pernight");
        System.out.println("2.Buisness Rooms \t5000pernight");
        System.out.println("3.General Rooms \t3500pernight");
        System.out.println("Enter the choice");
        int rooms = sc.nextInt();
        sc.nextLine();
        InformationOfCustomer info = new InformationOfCustomer();
        switch (rooms) {
            case 1:
            System.out.println("Enter the Details of the Customer for Delux Rooms");
            System.out.println("Enter the name"); 
            info.setName(sc.nextLine()); 
            System.out.println("Enter the phoneNumber");
            info.setPhone(sc.nextLong());
            System.out.println("Enter Valid Aadhar or Pan Card");
            info.setValidId(sc.next());
            numdays = sc.nextInt();
            payment = 7000*numdays;
            System.out.println("Total payment for " + numdays + " is : " + payment) ;
            break;
            case 2:
            System.out.println("Enter the Details of the Customer for Buisness Rooms");    
            System.out.println("Enter the name"); 
            info.setName(sc.nextLine()); 
            System.out.println("Enter the phoneNumber");
            info.setPhone(sc.nextLong());
            System.out.println("Enter Valid Aadhar or Pan Card");
            info.setValidId(sc.next());
            payment = 5000*numdays;
            System.out.println("Total payment for " + numdays + " is : " + payment) ;
            break;            
            case 3:
            System.out.println("Enter the Details of the Customer for General Rooms");  
            System.out.println("Enter the name"); 
            info.setName(sc.nextLine()); 
            System.out.println("Enter the phoneNumber");
            info.setPhone(sc.nextLong());
            System.out.println("Enter Valid Aadhar or Pan Card");
            info.setValidId(sc.next());  
            payment = 7000*numdays;
            System.out.println("Total payment for " + numdays + " is : " + payment) ;
            break;            
            default:
            System.out.println("No Service Available ");
            break;
        }
        sc.close();
    }
}
