import java.util.Scanner;

public class User_service {
    //change password
    static void ChangePassword(User_Details user , String oldpassword,String newPassword){
        if(!Security.CheckPassword(oldpassword,user)){
            System.out.println("Wrong password");
            return;
        }
        user.setPassword(newPassword);
    }

     static void ChangeUsername(User_Details user,String new_username,String oldpassword) {
        if(!Security.CheckPassword(oldpassword,user)){
            System.out.println("Wrong password");
            return;
        }
        user.setUsername(new_username);
    }

    public static void ChangeEmail(User_Details user,String NewEmail,String OldPassword) {
        if(!Security.CheckPassword(OldPassword,user)){
            System.out.println("Wrong password");
            return;
        }
        user.setEmail(NewEmail);
    }
    public static void ChangePIN(User_Details user,String PIN,String oldpassword) {
        if(!Security.CheckPassword(oldpassword,user)){
            System.out.println("Wrong password");
            return;
        }
        user.setPIN(PIN);
}


//Create account num
    static boolean Repeated (String accountnum){
        for (int i=0; i<User_Details.Users.size(); i++)
            if (accountnum.equals(User_Details.Users.get(i).getAccount_number()))return true;
        return false;

    }
    static String CreateAccountnum(){
        String accountnum="";
        for(int i =0 ; i<6; i++){
            double num=(Math.random()*10);
            int numInt=(int)num;
            accountnum+=numInt;
        }
        if(!Repeated(accountnum))return accountnum;
        return CreateAccountnum();
    }
    //Create PIN
    static String CreatePIN(){
        String PIN="";
        for(int i =0 ; i<3; i++){
            double num=(Math.random()*10);
            int numInt=(int)num;
            PIN+=numInt;
        }
        if(!Repeated(PIN))return PIN;
        return CreatePIN();
    }

    static String CreateID() {
        String ID = "";
        for (int i = 0; i < 3; i++) {
            double num = (Math.random() * 10);
            int numInt = (int) num;
            ID += numInt;
        }
        if(!Repeated(ID))return ID;
        return CreateID();
    }
    static String ShowData(User_Details user){
        return "ID: "+user.getID()+ " Email: "+user.getEmail()+" Account number: "+user.getAccount_number();
    }
    static void Menu_Operation(Operations op,User_Details user,Scanner sc){
        System.out.println("you do operations here , deposit , withdrawal and show amount ");
        System.out.println("For deposit enter 1 , for withdrawal enter 2 , for show operations enter 3 and for show Balance enter 4 ");
        System.out.println("For exist enter 5");
        int choice=sc.nextInt();

        while(choice!=5){
            System.out.println("Enter PIN");
            String PIN=sc.next();
            if(!Security.CheckPIN(PIN,user)){
                System.out.println("Wrong PIN");
                return;
            }
        switch (choice){
            case (1):
                System.out.println("Enter amount");
                op.deposit(sc.nextDouble());
                break;
            case (2):
                System.out.println("Enter amount");
                op.withdraw(sc.nextDouble());
                break;
            case(3):
                System.out.println(op.getOperations());
                System.out.println( op.getValues());
                break;
            case (4):
                System.out.println(op.getBalance());
                break;
        }
            choice=sc.nextInt();
    }



    }

    static void Change_userDetails(User_Details user,Scanner sc){
        System.out.println("you change your details here ");
        System.out.println("for change user name enter 1 , for change email enter 2 , for change password enter 3 , for change PIN enter 4 ");
        System.out.println("For exist enter 6");
        int choice = sc.nextInt();


        while(choice!=6){
            System.out.println("Enter password");
            String password=sc.next();
        switch (choice){
            case(1):
                System.out.println("enter user name: ");
                String userN=sc.next();

                User_service.ChangeUsername(user,userN,password);
                break ;
            case(2):
                System.out.println("enter Email:  ");
                String userE=sc.next();
                User_service.ChangeEmail(user,userE,password);
                break;
            case (3):
                System.out.println("enter password:  ");
                String userP=sc.next();

                User_service.ChangePassword(user,userP,password);
                break ;
            case (4):
                System.out.println("enter PIN:  ");
                String userPIN=sc.next();
                User_service.ChangePIN(user,userPIN,password);
        }
        choice=sc.nextInt();

    }
    }






















    static User_Details CreateUser(Scanner sc){
        System.out.println("Welcome to Bank account simulator,In frist enter your data");
        System.out.println("Enter username");
        String user_name=sc.next();
        System.out.println("Enter email");
        String email=sc.next();
        System.out.println("Enter password");
        String password=sc.next();
        return new User_Details(user_name,password,email,User_service.CreateAccountnum(),User_service.CreateID(),User_service.CreatePIN());

    }



    }

