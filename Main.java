import java.util.Scanner;
import java.util.ArrayList;
public class Main {



    public static void main(String[] args) {
        //user Service
        Scanner sc=new Scanner(System.in);
        User_Details user=User_service.CreateUser(sc);
        Operations op=new Operations();
        System.out.println(User_service.ShowData(user));
        System.out.println("For do operations enter 1 , for change your details enter 2 , for 3xist enter 3 ");
        int choice = sc.nextInt();
        while (choice!=3) {
            System.out.println("For do operations enter 1 , for change your details enter 2 , for 3xist enter 3 ");
            if (choice == 2) User_service.Menu_Operation(op,user,sc);
            else if (choice == 1) User_service.Change_userDetails(user,sc);
            choice = sc.nextInt();

        }



}}




