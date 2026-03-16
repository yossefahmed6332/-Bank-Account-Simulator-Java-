import java.util.Scanner;

public class Menues {
    //Admin menu
    static void getUser_Menu(Scanner sc,int choice,Admin_Service ser,UsersRepo repo) {
        System.out.println("if you want to get user by ID enter 1 , by email enter 2  , by username enter 3 and for get all users enter 4");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter user ID");
                String userID = sc.next();
                ser.getUser_ByID(userID,repo);
                break;
                case 2:
                    System.out.println("Enter user email");
                    String userEmail = sc.next();
                    ser.getUser_ByEmail(userEmail,repo);
                    break;
                    case 3:
                        System.out.println("Enter user account number");
                        String username = sc.next();
                        ser.getUser_ByUsername(username,repo);
                        break;
                        case 4:
                            ser.getAll_users(repo);
                            break;
                            default:
                                System.out.println("Wrong choice,try again");
                                getUser_Menu(sc,choice,ser,repo);

        }

    }
    static void admin_menu(Scanner sc,Admin_Service ser,UsersRepo repo) {
        int choice;
        System.out.println("Hello admin,this is a menu for ");
        System.out.println("to get user enter 1 and 2 to remove user");
        choice = sc.nextInt();
        switch(choice) {
            case 1:getUser_Menu(sc,choice,ser,repo);
            break;
            case 2:
                System.out.println("Enter user ID: ");
                String userID = sc.next();
                ser.removeUser(userID,repo);

        }

    }

    //user menu
    static void doOperation(Scanner sc,Security sec,User_Details user,Operations op,int choice,UsersRepo repo) {
        System.out.println("for deposit enter 1 , for withdraw  enter 2 ,for transfer enter 3 and for show transactions enter 4");
        choice = sc.nextInt();
        System.out.println("Enter PIN : ");
        String PIN =sc.next();
        System.out.println("Enter amount : ");
        int amount = sc.nextInt();
        switch(choice) {
            case 1:
                op.deposit(amount,sec,user,PIN);
                break;
                case 2:
                    op.withdraw(amount,sec,user,PIN);
                    break;
                    case 3:
                        System.out.println("Enter user's account number you send to");
                        String Accnum=sc.next();
                        op.transfer(amount,sec,user,Accnum,PIN,repo);
                        break;
                        case 4:
                            user.getTransactions();
                            break;
                            default:
                            System.out.println("Wrong choice,try again");
                            doOperation(sc,sec,user,op,choice,repo);

        }
    }
    static void changeData_menu(Scanner sc,User_Details user,Security sec,int choice,User_service ser) {
        System.out.println("for change password enter 1 , for change username enter 2 , for change email enter 3 and for change PIN enter 4");
        choice=sc.nextInt();
        System.out.println("Enter password : ");
        String password = sc.next();
        switch(choice) {
            case 1:
                System.out.println("Enter old password : ");
                String newpassword = sc.next();
                ser.ChangePassword(user,password,newpassword,sec);
                break;
                case 2:
                    System.out.println("Enter new user name: ");
                    String username = sc.next();
                    ser.ChangeUsername(user,username,password,sec);
                    break;
                    case 3:
                        System.out.println("Enter new email: ");
                        String email = sc.next();
                        ser.ChangeEmail(user,email,password,sec);
                        break;
                        case 4:
                            System.out.println("Enter new PIN: ");
                            String pin = sc.next();
                            ser.ChangePIN(user,pin,password,sec);
                            break;
                            default:
                                System.out.println("Wrong choice,try again");
                                changeData_menu(sc,user,sec,choice,ser);

        }

    }
    static void user_menu(Scanner sc,User_service ser,UsersRepo repo,Security sec,User_Details user,Operations op) {
        System.out.println("Hello User,this is a menu for: ");
        System.out.println("to do operation enter 1 and for change your data enter 2");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                doOperation(sc,sec,user,op,choice,repo);
                break;
                case 2:
                    changeData_menu(sc,user,sec,choice,ser);
                    break;
                    default:
                        System.out.println("Wrong choice,try again");
                        user_menu(sc,ser,repo,sec,user,op);

        }


    }

    //main menu

}
