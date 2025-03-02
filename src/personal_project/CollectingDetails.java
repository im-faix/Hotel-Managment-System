package personal_project;

import java.util.Scanner;

public class CollectingDetails {
    public static void addingDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("3 Types of Rooms");
        System.out.println("1.Delux Rooms \t7000pernight");
        System.out.println("2.Buisness Rooms \t5000pernight");
        System.out.println("3.General Rooms \t3500pernight");
        System.out.println("Enter the choice");
        int rooms = sc.nextInt();
        switch (rooms) {
            case 1:
                    System.out.println("Enter the Details of the Customer");                
                break;
        
            default:
                break;
        }
    }
}
