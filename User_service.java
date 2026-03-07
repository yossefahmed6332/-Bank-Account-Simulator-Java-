import java.util.Scanner;

    public class User_service {
        //change password
         void ChangePassword(User_Details user , String oldpassword,String newPassword,Security sec){
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPassword(newPassword);
        }

         void ChangeUsername(User_Details user,String new_username,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setUsername(new_username);
        }

         void ChangeEmail(User_Details user,String NewEmail,String OldPassword,Security sec) {
            if(!sec.CheckPassword(OldPassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setEmail(NewEmail);
        }
         void ChangePIN(User_Details user,String PIN,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPIN(PIN);
        }


        //Create account num
         boolean Repeated (String accountnum){
            for (int i=0; i<User_Details.users.size(); i++)
                if (accountnum.equals(User_Details.users.get(i).getAccount_number()))return true;
            return false;

        }
         String CreateAccountnum(){
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
         String CreatePIN(){
            String PIN="";
            for(int i =0 ; i<3; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                PIN+=numInt;
            }
            if(!Repeated(PIN))return PIN;
            return CreatePIN();
        }

         String CreateID() {
            String ID = "";
            for (int i = 0; i < 3; i++) {
                double num = (Math.random() * 10);
                int numInt = (int) num;
                ID += numInt;
            }
            if(!Repeated(ID))return ID;
            return CreateID();
        }
         String ShowData(User_Details user){
            return "ID: "+user.getID()+ " Email: "+user.getEmail()+" Account number: "+user.getAccount_number();
        }
         void Menu_Operation(Operations op,User_Details user,Scanner sc,Security sec){
            System.out.println("you do operations here , deposit , withdrawal and show amount ");
            System.out.println("For deposit enter 1 , for withdrawal enter 2 , for show operations enter 3 and for show Balance enter 4 ");
            System.out.println("For exist enter 5");
            int choice=sc.nextInt();

            while(choice!=5){
                System.out.println("Enter PIN");
                String PIN=sc.next();
                if(!sec.CheckPIN(PIN,user)){
                    System.out.println("Wrong PIN");
                    return;
                }
                switch (choice){
                    case (1):
                        System.out.println("Enter amount");
                        op.deposit(sc.nextDouble(),sec,user);
                        break;
                    case (2):
                        System.out.println("Enter amount");
                        op.withdraw(sc.nextDouble(),sec,user);
                        break;
                    case(3):
                        user.ShowTransactions();
                        break;
                    case (4):
                        System.out.println(user.getBalance());
                        break;
                }
                choice=sc.nextInt();
            }



        }

         void Change_userDetails(User_Details user,Scanner sc,User_service userService,Security sec){
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

                        userService.ChangeUsername(user,userN,password,sec);
                        break ;
                    case(2):
                        System.out.println("enter Email:  ");
                        String userE=sc.next();
                        userService.ChangeEmail(user,userE,password,sec);
                        break;
                    case (3):
                        System.out.println("enter password:  ");
                        String userP=sc.next();

                        userService.ChangePassword(user,userP,password,sec);
                        break ;
                    case (4):
                        System.out.println("enter PIN:  ");
                        String userPIN=sc.next();
                        userService.ChangePIN(user,userPIN,password,sec);
                }
                choice=sc.nextInt();

            }
        }


         User_Details CreateUser(Scanner sc,User_service userService){
            System.out.println("Welcome to Bank account simulator,In first enter your data");
            System.out.println("Enter username");
            String user_name=sc.next();
            System.out.println("Enter email");
            String email=sc.next();
            System.out.println("Enter password");
            String password=sc.next();
            return new User_Details(user_name,password,email,userService.CreateAccountnum(),userService.CreateID(),userService.CreatePIN());



    }


}
